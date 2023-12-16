package exceptions;

/**
 *
 * @author Group_10
 */
public class VarOutOfRangeException extends RuntimeException{

    /**
     * Creates a new instance of <code>VarOutOfRangeException</code> without
     * detail message.
     */
    public VarOutOfRangeException() {
    }

    /**
     * Constructs an instance of <code>VarOutOfRangeException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public VarOutOfRangeException(String msg) {
        super(msg);
    }
}
