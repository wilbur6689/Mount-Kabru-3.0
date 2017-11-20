
package java.exceptions;

/**
 *
 * @author wibur
 */
public class GameControlException extends Exception  {

    public GameControlException() {
    }

    public GameControlException(String string) {
        super(string);
    }

    public GameControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public GameControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public GameControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }

    
}
