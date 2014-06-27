/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bunnyrace.editor.fileio;

import bunnyrace.editor.Koordinaatit;
import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.imageio.ImageIO;

/**
 *
 * @author mikko
 */
public class MapLoader {

    public Pelitaso loadMap(File file) throws FileNotFoundException {
        Pelitaso palautus = new Pelitaso();
        palautus.setPolku(file);
        lueParametrit(palautus, file);
        palautus.setHerneet(lueHerneet(file));
        palautus.setMansikat(lueMansikat(file));
        palautus.setPommit(luePommit(file));
        palautus.setMaisema(lataaMaisema(file));



        return palautus;
    }

    private void lueParametrit(Pelitaso palautus, File file) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(file.getPath()+"/map.txt"));
        while (sc.hasNextLine()) {
            String rivi = sc.nextLine();

            if (rivi.startsWith("kuvia:")) {
                palautus.setKuvienlkm(Integer.parseInt(rivi.substring(6)));
            } else if (rivi.startsWith("skaala:")) {
                palautus.setSkaala(Float.parseFloat(rivi.substring(7)));
            } else if (rivi.startsWith("kuvanleveys:")) {
                palautus.setKuvanleveys(Integer.parseInt(rivi.substring(12)));
            } else if (rivi.startsWith("auto:")) {

                rivi = rivi.substring(5);
                String[] luvut = rivi.split(";");
                int autoX = Integer.parseInt(luvut[0]);
                int autoY = (Integer.parseInt(luvut[1]));
                Koordinaatit auto = new Koordinaatit(autoX, autoY);
                palautus.setAuto(auto);
            }
        }
        sc.close();
    }

    private ArrayList<Koordinaatit> lueHerneet(File file) throws FileNotFoundException {
        ArrayList<Koordinaatit> herneet = new ArrayList<Koordinaatit>();
        File tiedosto = new File(file.getPath() + "/herneet.txt");

        Scanner sc = new Scanner(tiedosto);

        String rivi;
        String[] luvut;
        int herneX;
        int herneY;

        while (sc.hasNextLine()) {
            rivi = sc.nextLine();
            try {
                luvut = rivi.split(";");
                herneX = Integer.parseInt(luvut[0]);
                herneY = Integer.parseInt(luvut[1]);
                //System.out.println("HerneX : " + herneX + " ja HerneY: "+ herneY);
                herneet.add(new Koordinaatit(herneX, herneY));
            } catch (Exception e) {
            }
        }
        sc.close();

        return herneet;

    }

    private ArrayList<Koordinaatit> lueMansikat(File file) throws FileNotFoundException {
        ArrayList<Koordinaatit> mansikat = new ArrayList<Koordinaatit>();
        File tiedosto = new File(file.getPath() + "/mansikat.txt");

        Scanner sc = new Scanner(tiedosto);

        String rivi;
        String[] luvut;
        int mansikkaX;
        int mansikkaY;

        while (sc.hasNextLine()) {
            rivi = sc.nextLine();
            try {
                luvut = rivi.split(";");
                mansikkaX = Integer.parseInt(luvut[0]);
                mansikkaY = Integer.parseInt(luvut[1]);
                //System.out.println("MansikkaX : " + mansikkaX + " ja MansikkaY: " + mansikkaY);
                mansikat.add(new Koordinaatit(mansikkaX, mansikkaY));
            } catch (Exception e) {
            }
        }
        sc.close();

        return mansikat;

    }

    private ArrayList<Koordinaatit> luePommit(File file) throws FileNotFoundException {
        ArrayList<Koordinaatit> pommit = new ArrayList<Koordinaatit>();
        File tiedosto = new File(file.getPath() + "/pommit.txt");

        Scanner sc = new Scanner(tiedosto);

        String rivi;
        String[] luvut;
        int pommiX;
        int pommiY;

        while (sc.hasNextLine()) {
            rivi = sc.nextLine();
            try {
                luvut = rivi.split(";");
                pommiX = Integer.parseInt(luvut[0]);
                pommiY = Integer.parseInt(luvut[1]);
                //System.out.println("PommiX : " + pommiX + " ja PommiY: "+ pommiY);
                pommit.add(new Koordinaatit(pommiX, pommiY));
            } catch (Exception e) {
            }
        }
        sc.close();

        return pommit;

    }

    private Image[] lataaMaisema(File file){
        String hakemisto = file.getPath() + "/img";
        String filepath;

        int laskuri;

        for (laskuri = 0; true; laskuri++) {

            if (laskuri < 10) {
                filepath = hakemisto + "/img_0" + laskuri + ".png";
            } else {
                filepath = hakemisto + "/img_" + laskuri + ".png";
            }

            //System.out.println("Filepath: " + filepath);
            
            try {

                Image image = ImageIO.read(new File(filepath));
            } catch (IOException ex) {
                break;
            }

        }

        Image[] palautus = new Image[laskuri];

        for (int i = 0; i<laskuri; i++) {

            if (i < 10) {
                filepath = hakemisto + "/img_0" + i + ".png";
            } else {
                filepath = hakemisto + "/img_" + i + ".png";
            }

            //System.out.println("Filepath: " + filepath);
            
            try {
                Image image = ImageIO.read(new File(filepath));
                palautus[i] = image;
            } catch (IOException ex) {
                break;
            }

        }

        return palautus;
    }
}
