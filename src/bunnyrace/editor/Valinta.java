/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bunnyrace.editor;

import java.util.Objects;

/**
 *
 * @author mikko
 */
public class Valinta {
    public Koordinaatit koord;
    public ValinnanTyyppi tyyppi;
    
    public Valinta(Koordinaatit valittu, ValinnanTyyppi tyyppi) {
        this.koord = valittu;
  
        this.tyyppi = tyyppi;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Valinta other = (Valinta) obj;
        if (!Objects.equals(this.koord, other.koord)) {
            return false;
        }
        return true;
    }
    
}
