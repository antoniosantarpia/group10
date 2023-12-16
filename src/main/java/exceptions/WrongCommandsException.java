package exceptions;

/**
 *
 * @author Group_10
 */
public class WrongCommandsException extends RuntimeException{

    /**
     * Creates a new instance of <code>WrongCommandsException</code> without
     * detail message.
     */
    public WrongCommandsException() {
    }

    /**
     * Constructs an instance of <code>WrongCommandsException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public WrongCommandsException(String msg) {
        super(msg);
    }
}
