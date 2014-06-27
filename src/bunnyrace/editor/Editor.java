/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bunnyrace.editor;

import bunnyrace.editor.fileio.MapCreator;
import bunnyrace.editor.fileio.MapLoader;
import bunnyrace.editor.fileio.MapSaver;
import bunnyrace.editor.fileio.Pelitaso;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author mikko
 */
public class Editor {

    private final MapLoader loader;
    private final MapSaver saver;
    private final MapCreator creator;
    private Pelitaso taso;
    private final ArrayList<Valinta> valitut;
    private Tila toiminto;
    private final Koordinaatit begin;
    private boolean move;
    private boolean select;
    private final Koordinaatit curSelect;

    public Editor() {
        this.loader = new MapLoader();
        this.saver = new MapSaver();
        this.creator = new MapCreator();
        this.toiminto = Tila.VALITSIN;
        this.valitut = new ArrayList<>();
        this.begin = new Koordinaatit(0, 0);
        this.curSelect = new Koordinaatit(0, 0);
    }
    
    public void exportImage(File file) {
        int pikkuKuvanKorkeus = 1024*2048/this.taso.getKuvanleveys();
        BufferedImage kuva = new BufferedImage(2048, pikkuKuvanKorkeus, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gr = kuva.createGraphics();
        for (int i = 0; i<taso.getMaisema().length; i++) {
            gr.drawImage(taso.getMaisema()[i], pikkuKuvanKorkeus*i, 0, pikkuKuvanKorkeus*(i+1), pikkuKuvanKorkeus, 0, 0, 1024, 1024, null);
        }
        gr.dispose();
        try {
            file.createNewFile();
            ImageIO.write(kuva, "png", file);
        } catch (IOException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void asetaValinta(Tila v) {
        this.valitut.clear();
        this.toiminto = v;
    }

    public boolean onkoValittu(Tila v) {
        return this.toiminto == v;
    }

    public void loadMap(File file) {
        Pelitaso t;
        try {
            t = this.loader.loadMap(file);
        } catch (Exception ex) {
            //ex.printStackTrace();
            return;
        }
        this.taso = t;
    }
    
    public void saveMap() {
        saver.saveMap(taso);
    }
    
    public void saveMapAs(File file) {
        saver.saveMapAs(taso, file);
    }

    public Pelitaso getPelitaso() {
        return this.taso;
    }

    public ArrayList<Valinta> getValitut() {
        return this.valitut;
    }
    
    /**
     * Tämä metodi kertoo editorille, että käyttäjä haluaa klikata tai muulla osoitinlaitteella osoittaa 
     * pelitason pisteeseen (x, y). Riippuen editorin tilasta tämä saa aikaan erilaisia asioita...
     * @param x x-koordinaatti tason pohjakuvan pikselikoordinaatteina
     * @param y y-koordinaatti tason pohjakuvan pikselikoordinaatteina
     * @param shift "onko shift painettuna pohjaan", vaikuttaa valitsemistoimintoon
     */

    public void click(int x, int y, boolean shift) {
        System.out.println("click (" +x+", " + y +")");
        switch (this.toiminto) {
            case VALITSIN:
                valitse(x, y, shift);
                break;
            case HERNE:
                lisaaHerne(x, y);
                break;
            case MANSIKKA:
                lisaaMansikka(x, y);
                break;
            case POMMI:
                lisaaPommi(x, y);
                break;
            case ALOITUS:
                this.taso.setAuto(new Koordinaatit(x, y));
                break;

        }
    }

    public void down(int x, int y) {
        //System.out.println("DOWN (" + x + ", " + y + ")");
        if(this.toiminto != Tila.VALITSIN) {
            return;
        }

        for (Valinta v : valitut) {
            if (Math.abs(v.koord.x - x) < 30) {
                if (Math.abs(v.koord.y - y) < 30) {
                    this.move = true;
                    this.begin.x = x;
                    this.begin.y = y;
                    return;
                }
            }
        }
        this.select = true;
        this.begin.x = x;
        this.begin.y = y;
        this.curSelect.x = x;
        this.curSelect.y = y;


    }
    
    public void createNewMap(File image, int skaala) {
        System.out.println("LUODAAN UUSI TASO");
        try {
            this.taso = creator.createMap(image, skaala);
        } catch (IOException ex) {
            Logger.getLogger(Editor.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void delete() {
        for (Valinta t : valitut) {
            this.taso.getHerneet().remove(t.koord);
            this.taso.getMansikat().remove(t.koord);
            this.taso.getPommit().remove(t.koord);
        }
        valitut.clear();
    }

    public boolean isSelect() {
        return this.select;
    }

    public Koordinaatit getSelectBegin() {
        return this.begin;
    }

    public Koordinaatit getSelectCurrent() {
        return this.curSelect;
    }

    public void move(int x, int y) {
        //System.out.println("MOVE (" + x + ", " + y + ")");
        if (move) {

            for (Valinta v : valitut) {
                v.koord.x = v.koord.x + (x - begin.x);
                v.koord.y = v.koord.y + (y - begin.y);
            }
            begin.x = x;
            begin.y = y;
        }

        if (select) {
            curSelect.x = x;
            curSelect.y = y;
            valitut.clear();
            valitseMaalatut();
        }
    }

    private void valitseMaalatut() {
        valitseMaalatut(this.taso.getHerneet(), ValinnanTyyppi.HERNE);
        valitseMaalatut(this.taso.getMansikat(), ValinnanTyyppi.MANSIKKA);
        valitseMaalatut(this.taso.getPommit(), ValinnanTyyppi.POMMI);

    }

    private void valitseMaalatut(ArrayList<Koordinaatit> lista, ValinnanTyyppi v) {
        for (Koordinaatit k : lista) {

            if ((k.x > this.begin.x && k.x < this.curSelect.x)
                    || (k.x > this.curSelect.x && k.x < this.begin.x)) {

                if ((k.y > this.begin.y && k.y < this.curSelect.y)
                        || (k.y > this.curSelect.y && k.y < this.begin.y)) {


                    if (!this.valitut.contains(new Valinta(k, v))) {
                        this.valitut.add(new Valinta(k, v));
                    }
                }
            }
        }
    }

    public void up(int x, int y) {
        //System.out.println("UP (" + x + ", " + y + ")");

        if (this.select) {
            valitseMaalatut();
        }

        this.move = false;
        this.select = false;
//        for (Koordinaatit k : valitut) {
//            k.x = k.x + (x - beginX);
//            k.y = k.y + (y - beginY);
//        }
    }

    private void valitse(int x, int y, boolean shift) {
        
        

        if (!shift) {
            valitut.clear();
        }

        ValinnanTyyppi v = ValinnanTyyppi.HERNE;
        for (Koordinaatit k : taso.getHerneet()) {
            if (Math.abs(k.x - x) < 30) {
                if (Math.abs(k.y - y) < 30) {
                    if (!valitut.contains(new Valinta(k, v))) {
                        valitut.add(new Valinta(k, v));
                    }
                }
            }
        }

        v = ValinnanTyyppi.MANSIKKA;
        for (Koordinaatit k : taso.getMansikat()) {
            if (Math.abs(k.x - x) < 30) {
                if (Math.abs(k.y - y) < 30) {
                    if (!valitut.contains(new Valinta(k, v))) {
                        valitut.add(new Valinta(k, v));
                    }
                }
            }
        }

        v = ValinnanTyyppi.POMMI;
        for (Koordinaatit k : taso.getPommit()) {
            if (Math.abs(k.x - x) < 30) {
                if (Math.abs(k.y - y) < 30) {
                    if (!valitut.contains(new Valinta(k, v))) {
                        valitut.add(new Valinta(k, v));
                    }
                }
            }
        }
    }

    private void lisaaHerne(int x, int y) {
        //System.out.println("Herne (" + x + ", " + y + ")");
        this.taso.getHerneet().add(new Koordinaatit(x, y));
    }

    private void lisaaMansikka(int x, int y) {
        //System.out.println("Mansikka (" + x + ", " + y + ")");
        this.taso.getMansikat().add(new Koordinaatit(x, y));
    }

    private void lisaaPommi(int x, int y) {
        //System.out.println("Pommi (" + x + ", " + y + ")");
        this.taso.getPommit().add(new Koordinaatit(x, y));
    }
}
