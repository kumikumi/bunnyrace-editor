/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bunnyrace.editor.gui;


import bunnyrace.editor.fileio.filters.DirectoryFilter;
import bunnyrace.editor.fileio.filters.DirectoryView;
import bunnyrace.editor.Editor;
import bunnyrace.editor.PngFilter;
import bunnyrace.editor.Tila;
import bunnyrace.editor.gui.PropertiesUI;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author mikko
 */
public class EditorUI extends javax.swing.JFrame {

    /**
     * Creates new form EditorUI
     * 
     * @param piirtologiikka
     */
    public EditorUI(Piirtologiikka piirtologiikka) {
        this.piirtologiikka = piirtologiikka;
        this.editori = piirtologiikka.getEditor();
        try {
            this.setIconImage(ImageIO.read(getClass().getResource("/logo.png")));
        } catch (IOException ex) {
        }
        initComponents();


    }
    
    public void updateUI() {
        //jScrollPane1.setViewportView(piirtologiikka);
        jScrollPane1.setViewportView(piirtoalusta1);
        piirtoalusta1.paivita();
    }

    //Oma metodi
    public void createMap(File image, int skaala) {
        this.editori.createNewMap(image, skaala);
        enabloiNapit();
        saveButton.setEnabled(false);
        jToggleButton1.setSelected(true);
        this.updateUI();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jToggleButton1 = new javax.swing.JToggleButton();
        jToggleButton3 = new javax.swing.JToggleButton();
        jToggleButton4 = new javax.swing.JToggleButton();
        jToggleButton5 = new javax.swing.JToggleButton();
        jToggleButton6 = new javax.swing.JToggleButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        deleteButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        piirtoalusta1 = new bunnyrace.editor.gui.Piirtoalusta(piirtologiikka);
        jToolBar2 = new javax.swing.JToolBar();
        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        newMissionButton = new javax.swing.JMenuItem();
        openMissionButton = new javax.swing.JMenuItem();
        saveButton = new javax.swing.JMenuItem();
        saveAsButton = new javax.swing.JMenuItem();
        exportButton = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutButton = new javax.swing.JMenuItem();
        copyButton = new javax.swing.JMenuItem();
        pasteButton = new javax.swing.JMenuItem();
        mapMenu = new javax.swing.JMenu();
        setMapScaleButton = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("BunnyRace-editor");
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nappiaPainettu(evt);
            }
        });

        jToolBar1.setFloatable(false);
        jToolBar1.setRollover(true);

        jToggleButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cursor.png"))); // NOI18N
        jToggleButton1.setToolTipText("Valitse");
        jToggleButton1.setEnabled(false);
        jToggleButton1.setFocusable(false);
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                valitseNappiaPainettu(evt);
            }
        });
        jToolBar1.add(jToggleButton1);

        jToggleButton3.setToolTipText("Herne");
        jToggleButton3.setEnabled(false);
        jToggleButton3.setFocusable(false);
        jToggleButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                herneNappiaPainettu(evt);
            }
        });
        jToolBar1.add(jToggleButton3);

        jToggleButton4.setToolTipText("Mansikka");
        jToggleButton4.setEnabled(false);
        jToggleButton4.setFocusable(false);
        jToggleButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mansikkaNappiaPainettu(evt);
            }
        });
        jToolBar1.add(jToggleButton4);

        jToggleButton5.setToolTipText("Pommi");
        jToggleButton5.setEnabled(false);
        jToggleButton5.setFocusable(false);
        jToggleButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pommiNappiaPainettu(evt);
            }
        });
        jToolBar1.add(jToggleButton5);

        jToggleButton6.setText("Aloituspaikka");
        jToggleButton6.setEnabled(false);
        jToggleButton6.setFocusable(false);
        jToggleButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToggleButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aloituspaikkaNappiaPainettu(evt);
            }
        });
        jToolBar1.add(jToggleButton6);
        jToolBar1.add(jSeparator1);

        deleteButton.setToolTipText("Poista");
        deleteButton.setEnabled(false);
        deleteButton.setFocusable(false);
        deleteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        deleteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                poistaNappiaPainettu(evt);
            }
        });
        jToolBar1.add(deleteButton);

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setWheelScrollingEnabled(false);
        jScrollPane1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                wheelMoved(evt);
            }
        });

        piirtoalusta1.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                wheel(evt);
            }
        });
        piirtoalusta1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                handleClick(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mouseDown(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                mouseUp(evt);
            }
        });
        piirtoalusta1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                EditorUI.this.mouseDragged(evt);
            }
        });

        javax.swing.GroupLayout piirtoalusta1Layout = new javax.swing.GroupLayout(piirtoalusta1);
        piirtoalusta1.setLayout(piirtoalusta1Layout);
        piirtoalusta1Layout.setHorizontalGroup(
            piirtoalusta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        piirtoalusta1Layout.setVerticalGroup(
            piirtoalusta1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 444, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(piirtoalusta1);

        jToolBar2.setFloatable(false);
        jToolBar2.setRollover(true);

        jLabel1.setText("Zoom:");
        jToolBar2.add(jLabel1);

        jSlider1.setMinimum(10);
        jSlider1.setValue(40);
        jSlider1.setEnabled(false);
        jSlider1.setPreferredSize(new java.awt.Dimension(206, 48));
        jSlider1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                hiiripainettu(evt);
            }
        });
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                zoomaus(evt);
            }
        });
        jToolBar2.add(jSlider1);

        jMenu1.setText("File");

        newMissionButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        newMissionButton.setText("New mission");
        newMissionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newMissionButtonActionPerformed(evt);
            }
        });
        jMenu1.add(newMissionButton);

        openMissionButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        openMissionButton.setText("Open mission ...");
        openMissionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMissionButtonActionPerformed(evt);
            }
        });
        jMenu1.add(openMissionButton);

        saveButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        saveButton.setText("Save");
        saveButton.setEnabled(false);
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });
        jMenu1.add(saveButton);

        saveAsButton.setText("Save as ...");
        saveAsButton.setEnabled(false);
        saveAsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveAsButtonActionPerformed(evt);
            }
        });
        jMenu1.add(saveAsButton);

        exportButton.setText("Export 2048px image");
        exportButton.setEnabled(false);
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });
        jMenu1.add(exportButton);

        jMenuBar1.add(jMenu1);

        editMenu.setText("Edit");

        cutButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        cutButton.setText("Cut");
        cutButton.setEnabled(false);
        editMenu.add(cutButton);

        copyButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        copyButton.setText("Copy");
        copyButton.setEnabled(false);
        editMenu.add(copyButton);

        pasteButton.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        pasteButton.setText("Paste");
        pasteButton.setEnabled(false);
        editMenu.add(pasteButton);

        jMenuBar1.add(editMenu);

        mapMenu.setText("Map");

        setMapScaleButton.setText("Set map scale ...");
        setMapScaleButton.setEnabled(false);
        setMapScaleButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setMapScaleButtonActionPerformed(evt);
            }
        });
        mapMenu.add(setMapScaleButton);

        jMenuBar1.add(mapMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.DEFAULT_SIZE, 512, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addComponent(jToolBar2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void zoomaus(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_zoomaus
        // TODO add your handling code here:
        //piirtoalusta1.setZoom(jSlider1.getValue() / 100.0);
        piirtologiikka.setZoom(jSlider1.getValue() / 100.0);

        this.updateUI();

        int yPalkinkorkeus = jScrollPane1.getVerticalScrollBar().getVisibleAmount();
        //System.out.println("Y-palkin korkeus " + yPalkinkorkeus);
        int yMaksimi = jScrollPane1.getVerticalScrollBar().getMaximum();
        jScrollPane1.getVerticalScrollBar().setValue((int) (yPalkinSuhteellinenKeskikohta * yMaksimi - (double) yPalkinkorkeus / 2));


        int xPalkinleveys = jScrollPane1.getHorizontalScrollBar().getVisibleAmount();
        int xMaksimi = jScrollPane1.getHorizontalScrollBar().getMaximum();
        jScrollPane1.getHorizontalScrollBar().setValue((int) (xPalkinSuhteellinenKeskikohta * xMaksimi - (double) xPalkinleveys / 2));
        //System.out.println("X-palkin leveys " + xPalkinleveys);
    }//GEN-LAST:event_zoomaus

    private void handleClick(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_handleClick
        // TODO add your handling code here:
        piirtologiikka.click(evt.getX(), evt.getY(), evt.isShiftDown());
        //piirtoalusta1.click(evt.getX(), evt.getY(), evt.isShiftDown());
        this.updateUI();

    }//GEN-LAST:event_handleClick

    private void hiiripainettu(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hiiripainettu
        // TODO add your handling code here:
        //System.out.println("Mouse pressed!");
        int xSkrollaus = jScrollPane1.getHorizontalScrollBar().getValue();
        int xPalkinleveys = jScrollPane1.getHorizontalScrollBar().getVisibleAmount();
        int xMaksimi = jScrollPane1.getHorizontalScrollBar().getMaximum();
//        System.out.println("Scrollaus: " + jScrollPane1.getHorizontalScrollBar().getValue());
//        System.out.println("Palkin leveys: " + jScrollPane1.getHorizontalScrollBar().getWidth());
//        System.out.println("Maksimi: " + jScrollPane1.getHorizontalScrollBar().getMaximum());
        xPalkinSuhteellinenKeskikohta = (xSkrollaus + (double) xPalkinleveys / 2) / xMaksimi;

        int ySkrollaus = jScrollPane1.getVerticalScrollBar().getValue();
        int yPalkinkorkeus = jScrollPane1.getVerticalScrollBar().getVisibleAmount();
        int yMaksimi = jScrollPane1.getVerticalScrollBar().getMaximum();
        //jScrollPane1.getVerticalScrollBar().getVisibleAmount();

        yPalkinSuhteellinenKeskikohta = (ySkrollaus + (double) yPalkinkorkeus / 2) / yMaksimi;

    }//GEN-LAST:event_hiiripainettu

    private void wheel(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_wheel
        // TODO add your handling code here:
        //System.out.println("DISPATCH");

        jScrollPane1.dispatchEvent(SwingUtilities.convertMouseEvent(piirtoalusta1, evt, jScrollPane1));

    }//GEN-LAST:event_wheel

    private void wheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_wheelMoved
        // TODO add your handling code here:

        int xSkrollaus = jScrollPane1.getHorizontalScrollBar().getValue();
        int xPalkinleveys = jScrollPane1.getHorizontalScrollBar().getVisibleAmount();
        int xMaksimi = jScrollPane1.getHorizontalScrollBar().getMaximum();

        double xKerroin = ((double) evt.getX() / jScrollPane1.getWidth());
        //System.out.println("xKerroin: " + xKerroin);
        double xPalkinHaluttuKohta = (xSkrollaus + (double) xPalkinleveys * xKerroin) / xMaksimi;

        int ySkrollaus = jScrollPane1.getVerticalScrollBar().getValue();
        int yPalkinkorkeus = jScrollPane1.getVerticalScrollBar().getVisibleAmount();
        int yMaksimi = jScrollPane1.getVerticalScrollBar().getMaximum();

        double yKerroin = ((double) evt.getY() / jScrollPane1.getHeight());
        //System.out.println("yKerroin: " + yKerroin);
        double yPalkinHaluttuKohta = (ySkrollaus + (double) yPalkinkorkeus * yKerroin) / yMaksimi;

        piirtologiikka.setZoom(Math.max(0.1, Math.min(piirtologiikka.getScale() - 0.05 * evt.getWheelRotation(), 1)));
        //piirtoalusta1.setZoom(Math.max(0.1, Math.min(piirtoalusta1.getScale() - 0.05 * evt.getWheelRotation(), 1)));
        this.updateUI();
        

        //jSlider1.setValue((int) (piirtoalusta1.getScale() * 100));
        jSlider1.setValue((int) (piirtologiikka.getScale() * 100));
        


        xPalkinleveys = jScrollPane1.getHorizontalScrollBar().getVisibleAmount();
        xMaksimi = jScrollPane1.getHorizontalScrollBar().getMaximum();

        jScrollPane1.getHorizontalScrollBar().setValue((int) (xPalkinHaluttuKohta * xMaksimi - (double) xPalkinleveys * xKerroin));


        yPalkinkorkeus = jScrollPane1.getVerticalScrollBar().getVisibleAmount();
        yMaksimi = jScrollPane1.getVerticalScrollBar().getMaximum();

        jScrollPane1.getVerticalScrollBar().setValue((int) (yPalkinHaluttuKohta * yMaksimi - (double) yPalkinkorkeus * yKerroin));

    }//GEN-LAST:event_wheelMoved

    private void openMissionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMissionButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser openFile = new JFileChooser();
        openFile.setDialogTitle("Import mission");
        openFile.setFileSelectionMode(1);
        DirectoryFilter filtteri = new DirectoryFilter();
        
        openFile.addChoosableFileFilter(filtteri);
        openFile.setFileFilter(filtteri);
        openFile.setFileView(new DirectoryView());
        int palautus = openFile.showOpenDialog(null);
        if (palautus != JFileChooser.APPROVE_OPTION) {
            System.out.println("Peruutettu");
            return;
        }
        File file = openFile.getSelectedFile();
        if (file == null) {
            return;
        }
        try {
        editori.loadMap(file);
        } catch (Exception e) {
            
        }
        saveButton.setEnabled(true);
        
        exportButton.setEnabled(true);
        enabloiNapit();
        jToggleButton1.setSelected(true);
        this.updateUI();

    }//GEN-LAST:event_openMissionButtonActionPerformed

    private void valitseNappiaPainettu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_valitseNappiaPainettu
        // TODO add your handling code here:
        System.out.println("Valitse");
        poistaValinnat();
        jToggleButton1.setSelected(true);
        editori.asetaValinta(Tila.VALITSIN);
        this.updateUI();
    }//GEN-LAST:event_valitseNappiaPainettu

    private void herneNappiaPainettu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_herneNappiaPainettu
        // TODO add your handling code here:
        poistaValinnat();
        jToggleButton3.setSelected(true);
        editori.asetaValinta(Tila.HERNE);
        this.updateUI();
    }//GEN-LAST:event_herneNappiaPainettu

    private void mansikkaNappiaPainettu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mansikkaNappiaPainettu
        // TODO add your handling code here:
        poistaValinnat();
        jToggleButton4.setSelected(true);
        editori.asetaValinta(Tila.MANSIKKA);
        this.updateUI();
    }//GEN-LAST:event_mansikkaNappiaPainettu

    private void pommiNappiaPainettu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pommiNappiaPainettu
        // TODO add your handling code here:
        poistaValinnat();
        jToggleButton5.setSelected(true);
        editori.asetaValinta(Tila.POMMI);
        this.updateUI();
    }//GEN-LAST:event_pommiNappiaPainettu

    private void aloituspaikkaNappiaPainettu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aloituspaikkaNappiaPainettu
        // TODO add your handling code here:
        poistaValinnat();
        jToggleButton6.setSelected(true);
        editori.asetaValinta(Tila.ALOITUS);
        this.updateUI();
    }//GEN-LAST:event_aloituspaikkaNappiaPainettu

    private void mouseDown(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseDown
        // TODO add your handling code here:
        //piirtoalusta1.mouseDown(evt.getX(), evt.getY());
        piirtologiikka.mouseDown(evt.getX(), evt.getY());
        this.updateUI();
    }//GEN-LAST:event_mouseDown

    private void mouseUp(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseUp
        // TODO add your handling code here:
        //piirtoalusta1.mouseUp(evt.getX(), evt.getY());
        piirtologiikka.mouseUp(evt.getX(), evt.getY());
        this.updateUI();

    }//GEN-LAST:event_mouseUp

    private void mouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseDragged
        // TODO add your handling code here:
        //piirtoalusta1.mouseDragged(evt.getX(), evt.getY());
        piirtologiikka.mouseDragged(evt.getX(), evt.getY());
        piirtoalusta1.paivita();

    }//GEN-LAST:event_mouseDragged

    private void poistaNappiaPainettu(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_poistaNappiaPainettu
        // TODO add your handling code here:
        editori.delete();
        this.updateUI();
    }//GEN-LAST:event_poistaNappiaPainettu

    private void nappiaPainettu(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nappiaPainettu
        // TODO add your handling code here:
        if (evt.getKeyCode() == 127) {
            editori.delete();
            this.updateUI();
        }
    }//GEN-LAST:event_nappiaPainettu

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        // TODO add your handling code here:
        editori.saveMap();
    }//GEN-LAST:event_saveButtonActionPerformed

    private void newMissionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newMissionButtonActionPerformed
        // TODO add your handling code here:
        JFrame creator = new CreatorUI(this);
        creator.setVisible(true);
        //new CreatorUI();
    }//GEN-LAST:event_newMissionButtonActionPerformed

    private void saveAsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveAsButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser saveFile = new JFileChooser();
        saveFile.setDialogTitle("Save mission");
        //saveFile.setFileSelectionMode(1);
        saveFile.showSaveDialog(null);
        File file = saveFile.getSelectedFile();
        if (file == null) {
            return;
        }
        //System.out.println(file.exists());

        file.mkdir();


        editori.saveMapAs(file);
        saveButton.setEnabled(true);
        
    }//GEN-LAST:event_saveAsButtonActionPerformed

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        // TODO add your handling code here:
        JFileChooser saveFile = new JFileChooser();
        saveFile.setDialogTitle("Export 2048px image file");
        //saveFile.setFileSelectionMode(1);
        PngFilter filtteri1 = new PngFilter();
        saveFile.addChoosableFileFilter(filtteri1);
        saveFile.setFileFilter(filtteri1);
        saveFile.showSaveDialog(null);
        File file = saveFile.getSelectedFile();
        if (file == null) {
            return;
        }
        String[] str = file.getName().split("\\.");
        if (str.length == 1 || !str[str.length-1].equals("png")) {
            file = new File(file.getPath()+".png");
        }
        //System.out.println(file.exists());



        editori.exportImage(file);
    }//GEN-LAST:event_exportButtonActionPerformed

    private void setMapScaleButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setMapScaleButtonActionPerformed
        // TODO add your handling code here:
        JFrame properties = new PropertiesUI(this, editori);
        properties.setVisible(true);
    }//GEN-LAST:event_setMapScaleButtonActionPerformed

    private void enabloiNapit() {
        jToggleButton1.setEnabled(true);
        jToggleButton3.setEnabled(true);
        jToggleButton4.setEnabled(true);
        jToggleButton5.setEnabled(true);
        jToggleButton6.setEnabled(true);
        jSlider1.setEnabled(true);
        exportButton.setEnabled(true);
        deleteButton.setEnabled(true);
        saveAsButton.setEnabled(true);
        setMapScaleButton.setEnabled(true);
//        this.copyButton.setEnabled(true);
//        this.pasteButton.setEnabled(true);
    }

    private void poistaValinnat() {
        jToggleButton1.setSelected(false);
        jToggleButton3.setSelected(false);
        jToggleButton4.setSelected(false);
        jToggleButton5.setSelected(false);
        jToggleButton6.setSelected(false);
    }
//
//    /**
//     * @param args the command line arguments
//     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(EditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(EditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(EditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(EditorUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new EditorUI().setVisible(true);
//            }
//        });
//
//
//    }
    private Piirtologiikka piirtologiikka;
    private Editor editori;
    private double xPalkinSuhteellinenKeskikohta;
    private double yPalkinSuhteellinenKeskikohta;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem copyButton;
    private javax.swing.JMenuItem cutButton;
    private javax.swing.JButton deleteButton;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exportButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton3;
    private javax.swing.JToggleButton jToggleButton4;
    private javax.swing.JToggleButton jToggleButton5;
    private javax.swing.JToggleButton jToggleButton6;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JMenu mapMenu;
    private javax.swing.JMenuItem newMissionButton;
    private javax.swing.JMenuItem openMissionButton;
    private javax.swing.JMenuItem pasteButton;
    private bunnyrace.editor.gui.Piirtoalusta piirtoalusta1;
    private javax.swing.JMenuItem saveAsButton;
    private javax.swing.JMenuItem saveButton;
    private javax.swing.JMenuItem setMapScaleButton;
    // End of variables declaration//GEN-END:variables
}