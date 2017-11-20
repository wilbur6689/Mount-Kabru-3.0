
package java.exceptions;

/**
 *
 * @author wibur
 */
public class NumberFormatException extends Exception{

    public NumberFormatException() {
    }

    public NumberFormatException(String string) {
        super(string);
    }

    public NumberFormatException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public NumberFormatException(Throwable thrwbl) {
        super(thrwbl);
    }

    public NumberFormatException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
    
}
