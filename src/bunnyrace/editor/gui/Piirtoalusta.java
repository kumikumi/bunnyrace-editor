/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bunnyrace.editor.gui;

import bunnyrace.editor.Editor;
import bunnyrace.editor.Koordinaatit;
import bunnyrace.editor.Valinta;
import bunnyrace.editor.fileio.Pelitaso;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author mikko
 */
public class Piirtoalusta extends JPanel {

    private final float HERNEEN_KOKO = 0.8f;
    private final float MANSIKAN_LEVEYS = 0.8f;
    private final float MANSIKAN_KORKEUS = 1.5f;
    private final float POMMIN_KOKO = 0.8f;
    private final int KUVANLEVEYS = 1024;
    private Image[] maisema;
    private Image mansikka;
    private Image herne;
    private Image pommi;
    private Pelitaso pelitaso;
    private Piirtologiikka piirtologiikka;

    public Piirtoalusta() {
        
    }

    public Piirtoalusta(Editor editori) {
        
    }
    
    public Piirtoalusta(Piirtologiikka piirtologiikka) {
        this.piirtologiikka = piirtologiikka;

        System.out.println("luodaan piirtoalusta");

        try {
            this.mansikka = ImageIO.read(this.getClass().getResource("/mansikka.png"));
            this.herne = ImageIO.read(this.getClass().getResource("/herne.png"));
            this.pommi = ImageIO.read(this.getClass().getResource("/pommi.png"));
        } catch (IOException ex) {
            System.err.println("Kuvien lukemisessa oli jotain outoja ongelmia");
        }

    }

    @Override
    public Dimension getPreferredSize() {
        return piirtologiikka.getPreferredSize();
    }

    @Override
    public void paintComponent(Graphics g) {
        System.out.println("Paint component");
        super.paintComponent(g);
        this.pelitaso = this.piirtologiikka.getPelitaso();
        if (this.piirtologiikka == null || this.pelitaso == null) {
            return;
        }

        piirraMaisema(g);

        piirraHerneet(g);
        piirraMansikat(g);
        piirraPommit(g);

        piirraAloitusKohta(g);

        piirraValinnat(g);

        if (this.piirtologiikka.isSelect()) {
            piirraValitseminen(g);
        }


    }

    private void piirraAloitusKohta(Graphics g) {
        g.setColor(Color.green);
        Koordinaatit auto = this.pelitaso.getAuto();
        g.fillOval((int) ((auto.x - 20) * this.piirtologiikka.getZoom()), (int) ((auto.y - 20) * this.piirtologiikka.getZoom()), (int) (40 * this.piirtologiikka.getZoom()), (int) (40 * this.piirtologiikka.getZoom()));
    }

    private void piirraMaisema(Graphics g) {
        this.maisema = pelitaso.getMaisema();
        this.setOpaque(true);
        this.setBackground(new Color(160, 220, 255));

        for (int i = 0; i < maisema.length; i++) {
            g.drawImage(maisema[i], piirtologiikka.getSkaalattuLeveys() * i, 0, piirtologiikka.getSkaalattuLeveys(), piirtologiikka.getSkaalattuLeveys(), this);
        }
    }

    private void piirraHerneet(Graphics g) {
        //g.setColor(new Color(34, 177, 76));
        ArrayList<Koordinaatit> herneet = pelitaso.getHerneet();
        float koko = (HERNEEN_KOKO * piirtologiikka.getSkaalaus());
        
        for (Koordinaatit k : herneet) {
            //g.fillOval((int) ((k.x - 25) * zoom), (int) ((k.y - 25) * zoom), (int) (50 * zoom), (int) (50 * zoom));
            g.drawImage(herne, (int) ((k.x - koko / 2) * this.piirtologiikka.getZoom()), (int) ((k.y - koko / 2) * this.piirtologiikka.getZoom()), (int) (koko * this.piirtologiikka.getZoom()), (int) (koko * this.piirtologiikka.getZoom()), this);
        }

    }

    private void piirraMansikat(Graphics g) {
        //g.setColor(Color.red);
        ArrayList<Koordinaatit> mansikat = pelitaso.getMansikat();
        float leveys = (MANSIKAN_LEVEYS * piirtologiikka.getSkaalaus());
        float korkeus = (MANSIKAN_KORKEUS * piirtologiikka.getSkaalaus());
        for (Koordinaatit k : mansikat) {
            //g.fillOval((int) ((k.x - 25) * zoom), (int) ((k.y - 25) * zoom), (int) (50 * zoom), (int) (50 * zoom));
            g.drawImage(mansikka, (int) ((k.x - leveys / 2) * this.piirtologiikka.getZoom()), (int) ((k.y - korkeus / 2) * this.piirtologiikka.getZoom()), (int) (leveys * this.piirtologiikka.getZoom()), (int) (korkeus * this.piirtologiikka.getZoom()), this);
        }

    }

    private void piirraPommit(Graphics g) {
        g.setColor(Color.black);
        ArrayList<Koordinaatit> pommit = pelitaso.getPommit();
        float leveys = (POMMIN_KOKO*piirtologiikka.getSkaalaus());
        float korkeus = leveys;
        for (Koordinaatit k : pommit) {
            //g.fillOval((int) ((k.x - leveys/2) * zoom), (int) ((k.y - korkeus/2) * zoom), (int) (leveys * zoom), (int) (korkeus * zoom));
            g.drawImage(pommi, (int) ((k.x - leveys / 2) * this.piirtologiikka.getZoom()), (int) ((k.y - korkeus / 2) * this.piirtologiikka.getZoom()), (int) (leveys * this.piirtologiikka.getZoom()), (int) (korkeus * this.piirtologiikka.getZoom()), this);
        }

    }

    private void piirraValinnat(Graphics g) {
        g.setColor(Color.YELLOW);
        int leveys = (int) ((MANSIKAN_LEVEYS * piirtologiikka.getSkaalaus()));
        int korkeus = (int) ((MANSIKAN_KORKEUS * piirtologiikka.getSkaalaus()));
        ArrayList<Valinta> valitut = this.piirtologiikka.getValitut();
        for (Valinta v : valitut) {
            switch (v.tyyppi) {
                case HERNE:
                    leveys = (int) ((HERNEEN_KOKO * piirtologiikka.getSkaalaus()));
                    korkeus = leveys;
                    break;
                case MANSIKKA:
                    leveys = (int) ((MANSIKAN_LEVEYS * piirtologiikka.getSkaalaus()));
                    korkeus = (int) ((MANSIKAN_KORKEUS * piirtologiikka.getSkaalaus()));
                    break;
                case POMMI:
                    leveys = (int) ((POMMIN_KOKO * piirtologiikka.getSkaalaus()));
                    korkeus = leveys;
                    break;
            }
            g.drawRect((int) ((v.koord.x - (leveys / 2)) * this.piirtologiikka.getZoom()), (int) ((v.koord.y - (korkeus / 2)) * this.piirtologiikka.getZoom()), (int) (leveys * this.piirtologiikka.getZoom()), (int) (korkeus * this.piirtologiikka.getZoom()));

        }
    }

    private void piirraValitseminen(Graphics g) {
        //System.out.println("valitseminen");
        g.setColor(Color.BLUE);
        int alkuX = (int) (Math.min(this.piirtologiikka.getSelectBegin().x, this.piirtologiikka.getSelectCurrent().x) * this.piirtologiikka.getZoom());
        int alkuY = (int) (Math.min(this.piirtologiikka.getSelectBegin().y, this.piirtologiikka.getSelectCurrent().y) * this.piirtologiikka.getZoom());
        int loppuX = (int) (Math.max(this.piirtologiikka.getSelectBegin().x, this.piirtologiikka.getSelectCurrent().x) * this.piirtologiikka.getZoom());
        int loppuY = (int) (Math.max(this.piirtologiikka.getSelectBegin().y, this.piirtologiikka.getSelectCurrent().y) * this.piirtologiikka.getZoom());

        g.drawRect(alkuX, alkuY, loppuX - alkuX, loppuY - alkuY);
    }

    public void paivita() {
        super.repaint();
    }
}
