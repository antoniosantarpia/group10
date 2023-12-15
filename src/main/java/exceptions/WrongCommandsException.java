/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author candi
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
