/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculatorapp;

import java.util.Deque;
import java.util.EmptyStackException;

/**
 *
 * @author Group_10
 */
public class StackOP {
    

    private Deque<ComplexNumber> stack;
    
    /**
     * Constructor
     *
     * @param stack stack containing the complex numbers
     */
    public StackOP(Deque<ComplexNumber> stack) {
        this.stack = stack;
    }
    
    
    
     /**
     * This method removes all the elements from the stack
     */
    public void clear() {
       
        stack.clear();
       

    }

    /**
     * This method removes the last element (top) from the stack.
     * It calls the EmptyStackException if the stack is empty
     */
    public void drop() {
        if(!stack.isEmpty())
          stack.removeFirst();
        else
            throw new EmptyStackException();

    }

    /**
     * This method pushes a copy of the last element into the stack.
     * It calls the EmptyStackException if the stack is empty
     */
    public void dup() {
       if(!stack.isEmpty()){
        ComplexNumber op1 = stack.removeFirst();
        stack.addFirst(op1);
        stack.addFirst(op1);
       }else{
           throw new EmptyStackException();
       }
    }

    /**
     * This method exchanges the last two inserted elements of the stack. 
     * It calls the EmptyStackException if the stack is empty or 
     * if there aren't enough elements
     */
    public void swap() {

        if (stack.size() >= 2) {
            ComplexNumber op1 = stack.removeFirst();
            ComplexNumber op2 = stack.removeFirst();

            stack.addFirst(op1);
            stack.addFirst(op2);
        } else {
            throw new EmptyStackException();
        }

    }

    /**
     * This method pushes a copy of the second last element into the stack.
     * It calls the EmptyStackException if the stack is empty or
     * if there aren't enough elements
     */
    public void over() {

        if (stack.size() >= 2) {
            ComplexNumber op1 = stack.removeFirst();
            ComplexNumber op2 = stack.removeFirst();

            stack.addFirst(op2);
            stack.addFirst(op1);
            stack.addFirst(op2);
        } else {
            throw new EmptyStackException();
        }
    }

}


