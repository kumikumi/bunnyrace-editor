/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bunnyrace.editor.fileio;

import bunnyrace.editor.Koordinaatit;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author kumikumi
 */
public class MapCreator {

    public Pelitaso createMap(File file, int skaala) throws IOException {
        Pelitaso palautus = new Pelitaso();
        palautus.setAuto(new Koordinaatit(0, 0));
        palautus.setHerneet(new ArrayList<Koordinaatit>());
        palautus.setMansikat(new ArrayList<Koordinaatit>());
        palautus.setPommit(new ArrayList<Koordinaatit>());

        palautus.setSkaala(skaala);
        Image kuva = ImageIO.read(file);
        kuva = skaalaaKuva(kuva);
        int kuvienlkm = (int) Math.ceil((double) kuva.getWidth(null) / 1024);
        palautus.setKuvanleveys(kuva.getWidth(null));
        palautus.setKuvienlkm(kuvienlkm);
        Image[] maisema = pilkoKuva(kuva, kuvienlkm);
        palautus.setMaisema(maisema);
        return palautus;
    }

    private Image skaalaaKuva(Image image) {
        if (image.getHeight(null) == 1024) {
            return image;
        }

        int uusiLeveys = (int) (image.getWidth(null) * (1024.0 / image.getHeight(null)));
        return image.getScaledInstance(uusiLeveys, 1024, 0);
    }

    private Image[] pilkoKuva(Image kuva, int kuvienlkm) {

        BufferedImage[] palautus = new BufferedImage[kuvienlkm];

        for (int i = 0; i < palautus.length - 1; i++) {
            palautus[i] = new BufferedImage(1024, 1024, BufferedImage.TYPE_INT_ARGB);
            Graphics2D gr = palautus[i].createGraphics();
            gr.drawImage(kuva, 0, 0, 1024, 1024, 1024 * i, 0, 1024 * i + 1024, 1024, null);
            gr.dispose();
        }

        int viimeisenKuvanLeveys = kuva.getWidth(null) % 1024;
        
        palautus[palautus.length-1] = new BufferedImage(1024, 1024, BufferedImage.TYPE_INT_ARGB);
        Graphics2D gr = palautus[palautus.length-1].createGraphics();
        gr.drawImage(kuva, 0, 0, viimeisenKuvanLeveys, 1024, 1024 * (palautus.length-1), 0, 1024 * (palautus.length-1) + viimeisenKuvanLeveys, 1024, null);
        gr.dispose();

        //System.out.println("KUVIEN LKM: " + kuvienlkm);



        return palautus;
    }
}
