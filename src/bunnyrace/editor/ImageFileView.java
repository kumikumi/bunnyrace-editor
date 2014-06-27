/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bunnyrace.editor;

import bunnyrace.editor.ImageFilter.Utils;
import java.io.File;
import javax.swing.filechooser.FileView;

/**
 *
 * @author mikko
 */
public class ImageFileView extends FileView {

    @Override
    public String getTypeDescription(File f) {
        String extension = Utils.getExtension(f);
        String type = null;

        if (extension != null) {
            if (extension.equals(Utils.jpeg)
                    || extension.equals(Utils.jpg)) {
                type = "JPEG Image";
            } else if (extension.equals(Utils.gif)) {
                type = "GIF Image";
            } else if (extension.equals(Utils.tiff)
                    || extension.equals(Utils.tif)) {
                type = "TIFF Image";
            } else if (extension.equals(Utils.png)) {
                type = "PNG Image";
            }
        }
        return type;
    }
    

}
