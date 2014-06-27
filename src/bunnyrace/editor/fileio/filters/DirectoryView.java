/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bunnyrace.editor.fileio.filters;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.filechooser.FileView;

/**
 *
 * @author mikko
 */
public class DirectoryView extends FileView {

    private Icon mapIcon;
    public DirectoryView() {
        try {
            this.mapIcon = new ImageIcon(ImageIO.read(getClass().getResource("/logo.png")).getScaledInstance(16, 16, 0));
        } catch (IOException ex) {
            Logger.getLogger(DirectoryView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Icon getIcon(File f) {
        //Icon icon = null;
        File file = new File(f.getAbsolutePath() + "/map.txt");
        if (file.exists()) {
            return mapIcon;
        }

        return super.getIcon(f);
    }
}


