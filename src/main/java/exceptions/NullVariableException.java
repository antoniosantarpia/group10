/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author candi
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
