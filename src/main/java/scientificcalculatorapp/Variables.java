/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculatorapp;

import exceptions.NullVariableException;
import exceptions.VarOutOfRangeException;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.LinkedList;

/**
 * This Variables Class used to manage the 26 variables and its operations
 *
 * @author Group_10
 */
public class Variables {
  private Deque <ComplexNumber> stack;
  private LinkedList <ComplexNumber> sv;


    public Variables(Deque<ComplexNumber> stack) {
        this.stack = stack;
        sv = new LinkedList<>();
       
        for(int i=0;i<26;i++)
            sv.add(null);
    }
    
    
    /**
     * The charToNum method convert the char of the range [a, b,.., z]
     * to numbers associated at the positions [0, 1, ..., 25]. 
     * 
     * @param ch variable in [a, b, ..., z]
     * @return the position number of the variable
     */
    private int charToNum(char ch)
    {
        if (ch < 'a' || ch > 'z') {
            throw new VarOutOfRangeException();
        }
        return (int) ch-97;
    }
    
    
    /**
     * This method allows to pop an element from the stack and assign it to variable choosed.
     * it call EmptyStackException if the stack is empty
     * 
     * @param ch variable in [a, b, ..., z]
     */
    public void assigntoVar(char ch)
    {
        int pos = charToNum(ch);
        ComplexNumber value = sv.get(pos);
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        sv.set(pos, stack.removeFirst());
    }
    
    
     /**
     * This method allows to copy an element from the variable and assign it to stack.
     * it call NullVariableException if the variable is empty
     * 
     * @param ch variable in [a, b, ..., z]
     */
    public void recoveryFromVar(char ch)
    {
        int pos = charToNum(ch);
        ComplexNumber value = sv.get(pos);
        if(value==null)
        {
            throw new NullVariableException();
        }
        stack.addFirst(new ComplexNumber (value.getReal(), value.getImg()));
    }
    
    
    
     /**
     * This method allows to pop one element from the stack and it sum with value of the variable.
     * it call NullVariableException if the variable is empty
     * 
     * @param ch variable in [a, b, ..., z]
     */
    public void sumtoVar(char ch)
    {
        int pos = charToNum(ch);
        ComplexNumber value = sv.get(pos);
        if(value==null)
        {
            throw new NullVariableException();
        }
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber se = stack.removeFirst();
        sv.set(pos, value.add(se));
    }
    
     /**
     * This method allows to pop one element from the stack and it subtract with value of the variable.
     * it call NullVariableException if the variable is empty
     * 
     * @param ch variable in [a, b, ..., z]
     */
    public void subtracttoVar(char ch)
    {
        int pos = charToNum(ch);
        ComplexNumber value = sv.get(pos);
        if(value==null)
        {
            throw new NullVariableException();
        }
        if(stack.isEmpty()){
            throw new EmptyStackException();
        }
        ComplexNumber se = stack.removeFirst();
        sv.set(pos, value.subtract(se));
    } 
    
}
