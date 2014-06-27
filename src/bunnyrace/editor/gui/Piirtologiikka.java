/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bunnyrace.editor.gui;

import bunnyrace.editor.Editor;
import bunnyrace.editor.Koordinaatit;
import bunnyrace.editor.Valinta;
import bunnyrace.editor.fileio.Pelitaso;
import java.awt.Dimension;
import java.util.ArrayList;

/**
 *
 * @author mikko
 */
public class Piirtologiikka {
    

    //Tekninen velka: pikseliä per metri
    private float skaalaus;
    //Herneen, mansikan ja pommin koot maailman yksiköinä
    private final float HERNEEN_KOKO = 0.8f;
    private final float MANSIKAN_LEVEYS = 0.8f;
    private final float MANSIKAN_KORKEUS = 1.5f;
    private final float POMMIN_KOKO = 0.8f;
    private final int KUVANLEVEYS = 1024;
    //public int zoom = 40;
    private double zoom = 0.5;
    private int skaalattuLeveys = (int) (zoom * KUVANLEVEYS);

    private final Editor editor;

    public Piirtologiikka(Editor e) {
        this.editor = e;
    }
    
    public Editor getEditor() {
        return this.editor;
    }
    
    public Pelitaso getPelitaso() {
        return this.editor.getPelitaso();
    }
    
    public double getZoom() {
        return this.zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
        this.skaalattuLeveys = (int) (zoom * KUVANLEVEYS);
    }
    
    public float getSkaalaus() {
        if (this.editor == null || this.editor.getPelitaso() == null) {
            return 1.0f;
        }
        this.skaalaus = this.editor.getPelitaso().getKuvanleveys() / this.editor.getPelitaso().getSkaala();
        return this.skaalaus;
    }

    public double getScale() {
        return this.zoom;
    }
    
    public boolean isSelect() {
        return this.editor.isSelect();
    }

    public Dimension getPreferredSize() {
        if (this.editor == null || this.editor.getPelitaso() == null) {
            return new Dimension(50, 50);
        }
        return new Dimension(editor.getPelitaso().getMaisema().length * skaalattuLeveys, skaalattuLeveys);
    }
    
    public ArrayList<Valinta> getValitut() {
        return this.editor.getValitut();
    }
    
    public Koordinaatit getSelectBegin() {
        return this.editor.getSelectBegin();
    }
    
    public Koordinaatit getSelectCurrent() {
        return this.editor.getSelectCurrent();
    }

    public void click(int x, int y, boolean shift) {
        if (this.editor.getPelitaso() == null) {
            return;
        }
        this.editor.click((int) (x / zoom), (int) (y / zoom), shift);
    }

    public void mouseDown(int x, int y) {
        if (this.editor.getPelitaso() == null) {
            return;
        }
        this.editor.down((int) (x / zoom), (int) (y / zoom));
    }

    public void mouseUp(int x, int y) {
        if (this.editor.getPelitaso() == null) {
            return;
        }
        this.editor.up((int) (x / zoom), (int) (y / zoom));
    }

    public void mouseDragged(int x, int y) {
        if (this.editor.getPelitaso() == null) {
            return;
        }
        this.editor.move((int) (x / zoom), (int) (y / zoom));
    }
    
    public int getSkaalattuLeveys() {
        return this.skaalattuLeveys;
    }

}
