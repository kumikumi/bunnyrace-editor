/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bunnyrace.editor.fileio;

import bunnyrace.editor.Koordinaatit;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author mikko
 */
public class Pelitaso {

    private File polku;
    private ArrayList<Koordinaatit> herneet;
    private ArrayList<Koordinaatit> mansikat;
    private ArrayList<Koordinaatit> pommit;
    private Koordinaatit auto;
    private Image[] maisema;
    private float skaala;
    private int kuvienlkm;
    private int kuvanleveys;

    public void setPolku(File polku) {
        this.polku = polku;
    }

    public File getPolku() {
        return this.polku;
    }

    public void setAuto(Koordinaatit paikka) {
        this.auto = paikka;
    }

    public Koordinaatit getAuto() {
        return this.auto;
    }

    public void setKuvienlkm(int kuvienlkm) {
        this.kuvienlkm = kuvienlkm;
    }

    public int getKuvienlkm() {
        return kuvienlkm;
    }

    public void setKuvanleveys(int kuvanleveys) {
        this.kuvanleveys = kuvanleveys;
    }

    public int getKuvanleveys() {
        return kuvanleveys;
    }

    public void setSkaala(float skaala) {
        this.skaala = skaala;
    }

    public float getSkaala() {
        return this.skaala;
    }

    public void setMaisema(Image[] t) {
        this.maisema = t;
    }

    public Image[] getMaisema() {
        return maisema;
    }

    public void setHerneet(ArrayList<Koordinaatit> herneet) {
        this.herneet = herneet;
    }

    public ArrayList<Koordinaatit> getHerneet() {
        return herneet;
    }

    public void setMansikat(ArrayList<Koordinaatit> mansikat) {
        this.mansikat = mansikat;
    }

    public ArrayList<Koordinaatit> getMansikat() {
        return mansikat;
    }

    public void setPommit(ArrayList<Koordinaatit> pommit) {
        this.pommit = pommit;
    }

    public ArrayList<Koordinaatit> getPommit() {
        return pommit;
    }
}
