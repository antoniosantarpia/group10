/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculatorapp;

import exceptions.ZeroDivisionException;
import java.util.Deque;
import java.util.EmptyStackException;

/**
 *
 * @author Group_10
 */
public class ComplexOperations {
     private Deque<ComplexNumber> stack;

    /**
     * Constructor
     *
     * @param stack stack containing the complex numbers
     */
    public ComplexOperations(Deque<ComplexNumber> stack) {
        this.stack = stack;
    }

    /**
     * Method to insert a complex number into the stack.
     *
     * @param k complex number to add into the stack
     */
    public void insertion(ComplexNumber k) {
        stack.addFirst(k);
    }
    

    /**
     * Method to sum 2 complex numbers pulled from the top of the stack.
     * It calls the EmptyStackException if the stack is empty or if 
     * there aren't enough operands
     */
    public void sum() {

        if (stack.size() >= 2) {
            ComplexNumber op1 = stack.removeFirst();
            ComplexNumber op2 = stack.removeFirst();
            stack.addFirst(op2.add(op1));
        } else {
            throw new EmptyStackException();
        }

    }

    /**
     * Method to subtract 2 complex numbers pulled from the top of the stack.
     * It calls the NoSuchElementException if the stack is empty or if 
     * there aren't enough operands
     */
    public void subtraction() {

        if (stack.size() >= 2) {
            ComplexNumber op1 = stack.removeFirst();
            ComplexNumber op2 = stack.removeFirst();

            stack.addFirst(op2.subtract(op1));
        } else {
            throw new EmptyStackException();
        }

    }

    /**
     * Method to multiply 2 complex numbers pulled from the top of the stack.
     * It calls the NoSuchElementException if the stack is empty or if there
     * aren't enough operands
     */
    public void product() {

        if (stack.size() >= 2) {
            ComplexNumber op1 = stack.removeFirst();
            ComplexNumber op2 = stack.removeFirst();

            stack.addFirst(op1.multiply(op2));
        } else {
            throw new EmptyStackException();
        }
    }

    /**
     * Method to divide 2 complex numbers pulled from the top of the stack. 
     * It calls the ZeroDivisionException when a complex number is divided by 0
     * It calls the EmptyStackException if the stack is empty or if there 
     * aren't enough operands
     */
    public void division() {

        if (stack.size() >= 2) {
            ComplexNumber op1 = stack.removeFirst();
            ComplexNumber op2 = stack.removeFirst();
           
            ComplexNumber res = op1.divide(op2);
            stack.addFirst(res);
                
           
        } else {
            throw new EmptyStackException();
        }
    }

    /**
     * Method to apply the square root of a complex number pulled from the top of the stack.
     * It calls the EmptyStackException if the stack is empty
     */
    public void squareRoot() {
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber op1 = stack.removeFirst();
        ComplexNumber result = op1.sqrt();
        stack.addFirst(result);
        stack.addFirst(result.inv());
        
    }

    /**
     * Method to invert the sign of a complex number pulled from the top of the stack.
     * It calls the NoSuchElementException if the stack is empty
     */
    public void invertedSign() {
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber op1 = stack.removeFirst();
        stack.addFirst(op1.inv());
    }
    
    
    
    


}
