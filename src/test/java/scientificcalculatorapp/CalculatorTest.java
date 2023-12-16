/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package scientificcalculatorapp;

import exceptions.VarOutOfRangeException;
import exceptions.WrongCommandsException;
import exceptions.ZeroDivisionException;
import java.util.Deque;
import java.util.LinkedList;
import jdk.internal.org.objectweb.asm.tree.analysis.Interpreter;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Group_10
 */
public class CalculatorTest {
    
    
    private Calculator calculator;
    private Deque<ComplexNumber> stack;
    
    public CalculatorTest() {
        
    }
    
   
    @BeforeEach
    public void setUp() {
        stack = new LinkedList<>();
        calculator = new Calculator(stack);
    }
    
   

    /**
     * Test of parse method, of class Calculator.
     */
    @Test
    public void testParse() {
        System.out.println("Test parse method: a set of insertions");
        calculator.parse("021");
        assertEquals(new ComplexNumber(21, 0), stack.getFirst());

        calculator.parse("-021");
        assertEquals(new ComplexNumber(-21, 0), stack.getFirst());

        calculator.parse("-0j");
        assertEquals(new ComplexNumber(0.0, -0.0), stack.getFirst());

        calculator.parse("-054j");
        assertEquals(new ComplexNumber(0.0, -54.0), stack.getFirst());

        calculator.parse("+0j");
        assertEquals(new ComplexNumber(0.0, 0.0), stack.getFirst());

        calculator.parse("02j");
        assertEquals(new ComplexNumber(0.0, 2.0), stack.getFirst());
        
        calculator.parse("j");
        assertEquals(new ComplexNumber(0, 1), stack.getFirst());

        calculator.parse("1+j");
        assertEquals(new ComplexNumber(1, 1), stack.getFirst());

        calculator.parse("1-j");
        assertEquals(new ComplexNumber(1, -1), stack.getFirst());
        
        calculator.parse("2+8j");
        assertEquals(new ComplexNumber(2, 8), stack.getFirst());

        calculator.parse("33");
        assertEquals(new ComplexNumber(33, 0), stack.getFirst());

        calculator.parse("42j");
        assertEquals(new ComplexNumber(0, 42), stack.getFirst());

        calculator.parse("-7-10j");
        assertEquals(new ComplexNumber(-7, -10), stack.getFirst());
 
        calculator.parse(".5+3j");
        assertEquals(new ComplexNumber(0.5, 3), stack.getFirst());
        
        calculator.parse("0.001+7j");
        assertEquals(new ComplexNumber(0.001, 7), stack.getFirst());

        calculator.parse("3-0.001j");
        assertEquals(new ComplexNumber(3, -0.001), stack.getFirst());

        calculator.parse("-4444444-4444444j");
        assertEquals(new ComplexNumber(-4444444, -4444444), stack.getFirst());

        calculator.parse("7654321-7654321j");
        assertEquals(new ComplexNumber(7654321, -7654321), stack.getFirst());
        
        calculator.parse("0");
        assertEquals(new ComplexNumber(0, 0), stack.getFirst());

        calculator.parse("+0");
        assertEquals(new ComplexNumber(0, 0), stack.getFirst());

        calculator.parse("-0");
        assertEquals(new ComplexNumber(-0.0, 0.0), stack.getFirst());

        calculator.parse("0j");
        assertEquals(new ComplexNumber(0, 0), stack.getFirst());
        
        calculator.parse(".5");
        assertEquals(new ComplexNumber(0.5, 0), stack.getFirst());
        
        calculator.parse(".7j");
        assertEquals(new ComplexNumber(0, .7), stack.getFirst());
        
        
    }
    
    @Test
    public void testParseOperation() {
       System.out.println("Test parse method: a set of aritmethic operations");
        calculator.parse("3+7j");
        calculator.parse("5+10j");
        calculator.parse("+");
        assertEquals(new ComplexNumber(8, 17), stack.getFirst());
        stack.removeFirst();
        
        calculator.parse("78-7j");
        calculator.parse("4+10j");
        calculator.parse("-");
        assertEquals(new ComplexNumber(74, -17), stack.getFirst());
        stack.removeFirst();
        
        calculator.parse("7");
        calculator.parse("0+10j");
        calculator.parse("*");
        assertEquals(new ComplexNumber(0, 70), stack.getFirst());
        stack.removeFirst();
        
        calculator.parse("1+2j");
        calculator.parse("9+9j");
        calculator.parse("/");
        ComplexNumber expected = new ComplexNumber(0.167, 0.056);
        ComplexNumber actual = stack.getFirst();
        assertEquals(expected.getReal(), actual.getReal(), 0.001);
        assertEquals(expected.getImg(), actual.getImg(), 0.001);
        stack.removeFirst();
        
        
        calculator.parse("64+64j");
        calculator.parse("sqrt");
        ComplexNumber expected1 = new ComplexNumber(-8.789, -3.641);
        ComplexNumber actual1 = stack.getFirst();
        assertEquals(expected1.getReal(), actual1.getReal(), 0.001);
        stack.removeFirst();
        ComplexNumber expected2 = new ComplexNumber(8.789, 3.641);
        ComplexNumber actual2 = stack.getFirst();
        assertEquals(expected2.getImg(), actual2.getImg(), 0.001);
        stack.removeFirst();        
    }
    
    
    @Test
    public void testParseStackOperation(){
        System.out.println("Test parse method: a set of stack operations");
        calculator.parse("6j");
        calculator.parse("clear");
        assertTrue(stack.isEmpty());
        
        calculator.parse("5+7j");
        calculator.parse("6+9j");
        calculator.parse("drop");
        assertEquals(stack.getFirst(), new ComplexNumber(5, 7));
        stack.removeFirst();
        
        calculator.parse("0");
        calculator.parse("-445+j");
        calculator.parse("dup");
        assertEquals(stack.getFirst(), new ComplexNumber(-445, 1));
        stack.removeFirst();
        stack.removeFirst();
        stack.removeFirst();
        
        calculator.parse("5+j");
        calculator.parse("-6");
        calculator.parse("swap");
        assertEquals(stack.getFirst(), new ComplexNumber(5, 1));
        assertEquals(stack.getLast(), new ComplexNumber(-6, 0));
        stack.removeFirst();
        
        calculator.parse("7-j");
        calculator.parse("8");
        calculator.parse("over");
        assertEquals(stack.getFirst(), new ComplexNumber(7, -1));
        stack.removeFirst();
    }
    
    @Test
    public void testParseVariable(){
        System.out.println("Test parse method: a set of variable operations");
        calculator.parse("3+5j");
        calculator.parse("1+0j");
        calculator.parse(">x"); 
        calculator.parse("+x");
        calculator.parse("<x");
        assertEquals(new ComplexNumber(4, 5), stack.getFirst());
        stack.removeFirst();
        
        calculator.parse("3+7j");
        calculator.parse("1+0j");
        calculator.parse(">x"); 
        calculator.parse("-x");
        calculator.parse("<x");
        assertEquals(new ComplexNumber(-2, -7), stack.getFirst());
        stack.removeFirst();
        
        
        
    }
    
    
    @Test
    public void ParseVariableFail1() {
         System.out.println("Method testParseVariableFail1");
         assertThrows(WrongCommandsException.class, () -> {
           calculator.parse(">");
        });
    }
    
    
    @Test
    public void ParseVariableFail2() {
         System.out.println("Method ParseVariableFail2");
         assertThrows(WrongCommandsException.class, () -> {
           calculator.parse(">ab");
        });
    }
    
    @Test
    public void ParseVariableFail3() {
         System.out.println("Method ParseVariableFail3");
         assertThrows(WrongCommandsException.class, () -> {
           calculator.parse("-ab");
        });
    }
     
      
    @Test
    public void ParseInsertionFail1() {
         System.out.println("Method ParseInsertionFail1");
         assertThrows(WrongCommandsException.class, () -> {
           calculator.parse("j1");
        });
    }
    
    @Test
    public void ParseInsertionFail2() {
         System.out.println("Method ParseInsertionFail2");
         assertThrows(WrongCommandsException.class, () -> {
           calculator.parse("25-31");
        });
    }
    
     @Test
    public void ParseInsertionFail3() {
         System.out.println("Method ParseInsertionFail3");
         assertThrows(WrongCommandsException.class, () -> {
           calculator.parse("25+31");
        });
    }
    
    @Test
    public void ParseInsertionFail4() {
         System.out.println("Method ParseInsertionFail4");
         assertThrows(WrongCommandsException.class, () -> {
           calculator.parse("5*8.4");
        });
    }
    
    @Test
    public void ParseInsertionFail5() {
         System.out.println("Method ParseInsertionFail5");
         assertThrows(WrongCommandsException.class, () -> {
           calculator.parse("5/8.4");
        });
    }
    
    @Test
    public void ParseInsertionFail6() {
         System.out.println("Method ParseInsertionFail6");
         assertThrows(WrongCommandsException.class, () -> {
           calculator.parse("sqrt64");
        });
    }
    
    @Test
    public void ParseInsertionFail7(){
         System.out.println("Method ParseInsertionFail7");
         assertThrows(WrongCommandsException.class, () -> {
           calculator.parse("+/-64");
        });
    }
    
    @Test
    public void ParseInsertionFail8(){
         System.out.println("Method ParseInsertionFail8");
         assertThrows(VarOutOfRangeException.class, () -> {
           calculator.parse("swapp");
        });
    }
    
    @Test
    public void ParseInsertionFail9() {
         System.out.println("Method ParseInsertionFail9");
         assertThrows(VarOutOfRangeException.class, () -> {
           calculator.parse("drropp");
        });
    }
    
    @Test
    public void ParseInsertionFail10() {
        System.out.println("Method ParseInsertionFail10");
         assertThrows(VarOutOfRangeException.class, () -> {
           calculator.parse("cleaar");
        });
    }
    
     
    
    
    
    
    
}
