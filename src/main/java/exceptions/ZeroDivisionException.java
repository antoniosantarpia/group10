/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package exceptions;

/**
 *
 * @author candi
 */
public class ZeroDivisionException extends RuntimeException{

    /**
     * Creates a new instance of <code>ZeroDivisionException</code> without
     * detail message.
     */
    public ZeroDivisionException() {
       
    }

    /**
     * Constructs an instance of <code>ZeroDivisionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ZeroDivisionException(String msg) {
        super(msg);
    }
}
