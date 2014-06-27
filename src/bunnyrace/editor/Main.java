/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bunnyrace.editor;

import bunnyrace.editor.gui.EditorUI;
import bunnyrace.editor.gui.Piirtologiikka;

/**
 *
 * @author mikko
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Editor editori = new Editor();
        Piirtologiikka piirtologiikka = new Piirtologiikka(editori);
        final EditorUI editorUI = new EditorUI(piirtologiikka);
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                editorUI.setVisible(true);
            }
        });
    }

}
