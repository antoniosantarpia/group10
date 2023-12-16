package exceptions;

/**
 *
 * @author Group_10
 */
public class NullVariableException extends RuntimeException{

    /**
     * Creates a new instance of <code>NullVariableException</code> without
     * detail message.
     */
    public NullVariableException() {
    }

    /**
     * Constructs an instance of <code>NullVariableException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public NullVariableException(String msg) {
        super(msg);
    }
}
