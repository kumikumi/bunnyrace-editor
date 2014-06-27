/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bunnyrace.editor;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author mikko
 */
public class PngFilter extends FileFilter{

    @Override
    public boolean accept(File f) {
    if (f.isDirectory()) {
        return true;
    }

    String extension = ImageFilter.Utils.getExtension(f);
    if (extension != null) {
        if (extension.equals(ImageFilter.Utils.png)) {
                return true;
        } else {
            return false;
        }
    }

    return false;
}
    @Override
    public String getDescription() {
        return "PNG (.png)";
    }
    
}
