/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculatorapp;

import exceptions.VarOutOfRangeException;
import exceptions.WrongCommandsException;
import java.util.Deque;


/**
 * Calculator class contains logic to control the sequence of string operations
 * 
 * @author Group_10
 */
public class Calculator {
    private ComplexOperations co;
    private Variables vs;
    private StackOP stack;
    

    public Calculator(Deque<ComplexNumber> stack) {
        this.stack = new StackOP(stack);
        vs = new Variables(stack);
        co = new ComplexOperations(stack);
    }
    
    
    /**
     * The JPart method returns true if the string represents the j operand.
     * 
     * 
     * @param str is the input text
     * @return boolean
     */
    private boolean JPart(String str){
        return str.matches("^[+-]?j$");
    }
    
    
    /**
     * The isOPComplex method returns true if the string represents only the imaginary part like a
     * " +/-imgPart*j ".
     * 
     * @param str is the input text
     * @return boolean
     */
    private boolean isImg(String str) {
        return str.matches("^[+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)[j]$");

    }
    
   
    /**
     * The isOPComplex method returns true if the string represents a complex operand like a
     * " +/-realPart +/-imgPart*j ".
     * 
     * @param str is the input text
     * @return boolean
    */
    private boolean isOPComplex(String str) {
        return str.matches("^(?=[j.\\d+-])([+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)(?![j.\\d]))([+-]?(?:(?:\\d+(?:\\.\\d*)?|\\.\\d+))?[j])?$");
   
    } 
    


    /**     
     * The parse method is used to recognize the operations and different operands from the string
     * read on the input. This methos calls each method of the class ComplexOperations,
     * each method of the class StackOP and each method of the class Variables.
     *
     * @param str is the content of display
     */
    public void parse(String str) {

            ComplexNumber cn = null;
            
            if(JPart(str)){
                if(str.charAt(0) == '+' || str.charAt(0) == 'j'){
                    cn = new ComplexNumber(0, 1);
                    co.insertion(cn);
                }else if(str.charAt(0) == '-'){
                    cn = new ComplexNumber(0, -1);
                    co.insertion(cn);
                }
                
            }else if(isImg(str)){
               
                String img[] = str.split("(?=[j])");
                cn = new ComplexNumber(0, Double.parseDouble(img[0]));
                co.insertion(cn);
                
            }else if(isOPComplex(str)){
                    if(str.matches("^[+-]?[0-9]*\\.?[0-9]+$")){ /* number with only the real part */
                        cn = new ComplexNumber(Double.parseDouble(str), 0);
                        co.insertion(cn);
                
                    }else if(str.matches("^[+-]?[0-9]*\\.?[0-9]+([+-]\\s*j)$")){ /* number with real part and imaginary part equals to 1*/
                        String realAndj[] = str.split("(?=[+-]j)");
                        if(realAndj[1].equals("+j")){
                            cn = new ComplexNumber(Double.parseDouble(realAndj[0]), 1);
                            co.insertion(cn);
                        }else{
                            cn = new ComplexNumber(Double.parseDouble(realAndj[0]), -1);
                            co.insertion(cn);
                        }
        
                    }else if(str.matches("^[-+]?\\d*\\.?\\d+[+-]\\d*\\.?\\d+j$")){ /* number whith real part and imaginary part */
                        String realAndImg[] = str.split("(?=[+-]\\d)");
                        String imgAndJ[] = realAndImg[1].split("(?=[j])");
                        cn = new ComplexNumber(Double.parseDouble(realAndImg[0]), Double.parseDouble(imgAndJ[0]));
                        co.insertion(cn);
                    }
         
            } else if (str.equals("+")) {
                co.sum();
            } else if (str.equals("-")) {
                co.subtraction();
            } else if (str.equals("*")) {
                co.product();
            } else if (str.equals("/")) {
                co.division();
            } else if (str.equals("+/-")) {
                co.invertedSign();
            } else if (str.equals("sqrt")) {
                co.squareRoot();
            } else if (str.equals("over")) {
                stack.over();
            } else if (str.equals("clear")) {
                stack.clear();
            } else if (str.equals("dup")) {
                stack.dup();
            } else if (str.equals("swap")) {
                stack.swap();
            } else if (str.equals("drop")) {
                stack.drop();
            }else if (str.length() == 2 && str.charAt(0) == '<') {
                vs.recoveryFromVar(str.charAt(1));
            }else if (str.length() == 2 && str.charAt(0) == '>') {
                vs.assigntoVar(str.charAt(1));
            } else if (str.length() == 2 && str.charAt(0) == '-') {
                vs.subtracttoVar(str.charAt(1));
            } else if (str.length() == 2 && str.charAt(0) == '+') {
                vs.sumtoVar(str.charAt(1));
            } else if (str.length() == 1 && (str.charAt(0) >= 'a' && str.charAt(0) <= 'z')){
                
            } else if (str.matches("^[a-z ]{2,}$")){
             
                throw new VarOutOfRangeException();
            }
            else{
                throw new WrongCommandsException();
            }
    }
       
   

    
}
