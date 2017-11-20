
package kabru.exceptions;

/**
 *
 * @author wibur
 */
public class ActorControlException extends Exception {

    public ActorControlException() {
    }

    public ActorControlException(String string) {
        super(string);
    }

    public ActorControlException(String string, Throwable thrwbl) {
        super(string, thrwbl);
    }

    public ActorControlException(Throwable thrwbl) {
        super(thrwbl);
    }

    public ActorControlException(String string, Throwable thrwbl, boolean bln, boolean bln1) {
        super(string, thrwbl, bln, bln1);
    }
    
    
    
    
}
