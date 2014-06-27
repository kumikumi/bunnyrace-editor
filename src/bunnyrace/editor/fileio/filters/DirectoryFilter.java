/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bunnyrace.editor.fileio.filters;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author mikko
 */
public class DirectoryFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        if (f.isDirectory()) {
            return true;
        }
        return false;
    }

    @Override
    public String getDescription() {
        return "Hakemistot";
    }
}
