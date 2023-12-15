/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package scientificcalculatorapp;

import java.util.Deque;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author antoniosantarpia
 */
public class ComplexOperationsTest {
    private Deque<ComplexNumber> stack;
    private ComplexOperations co;
    
    @BeforeEach
    public void setUp() {
        stack = new LinkedList<>();
        co = new ComplexOperations(stack);
    }
    
    /**
     * Test of insertion method, of class ComplexOperations.
     */
    @Test
    public void testInsertion() {
        System.out.println("Test Insertion");
        
        ComplexNumber num1 = new ComplexNumber(2.0 , -37.2);
        
        co.insertion(num1);
        
        assertEquals(num1,stack.peekFirst());
    }

    /**
     * Test of sum method, of class ComplexOperations.
     */
    @Test
    public void testSum() {
        System.out.println("Test Sum");
        
        ComplexNumber num1 = new ComplexNumber(4.0 , -6.6);
        ComplexNumber num2 = new ComplexNumber(18.0 , -3.1);
        
        co.insertion(num1);
        co.insertion(num2);
        
        
        ComplexNumber expectedResult = new ComplexNumber(22.0, -9.7);
        co.sum();
        
        assertEquals(expectedResult.getReal(), stack.peekFirst().getReal(), 0.0001);
        assertEquals(expectedResult.getImg(), stack.peekFirst().getImg(), 0.0001);

        
    }

    /**
     * Test of subtraction method, of class ComplexOperations.
     */
    @Test
    public void testSubtraction() {
        System.out.println("Test Sub");
        
        ComplexNumber num1 = new ComplexNumber(3.0 , -4.1);
        ComplexNumber num2 = new ComplexNumber(7.0 , -5.4);
        
        co.insertion(num1);
        co.insertion(num2);
        
        
        ComplexNumber expectedResult = new ComplexNumber(-4.0, 1.3);
        co.subtraction();
        
        assertEquals(expectedResult.getReal(), stack.peekFirst().getReal(), 0.0001);
        assertEquals(expectedResult.getImg(), stack.peekFirst().getImg(), 0.0001);
        
    }

    /**
     * Test of product method, of class ComplexOperations.
     */
    @Test
    public void testProduct() {
        System.out.println("Test Product");
        
        ComplexNumber num1 = new ComplexNumber(2.0 , 0.1);
        ComplexNumber num2 = new ComplexNumber(4.5 , 4.4);
        
        co.insertion(num1);
        co.insertion(num2);
        
        
        ComplexNumber expectedResult = new ComplexNumber(8.56, 9.25);
        co.product();
        
        assertEquals(expectedResult.getReal(), stack.peekFirst().getReal(), 0.0001);
        assertEquals(expectedResult.getImg(), stack.peekFirst().getImg(), 0.0001);
        
    }

    /**
     * Test of division method, of class ComplexOperations.
     */
    @Test
    public void testDivision() {
        System.out.println("Test Division");
        
        ComplexNumber num1 = new ComplexNumber(9.0 , 0.8);
        ComplexNumber num2 = new ComplexNumber(3.5 , 6.0);
        
        co.insertion(num1);
        co.insertion(num2);
        
        
        ComplexNumber expectedResult = new ComplexNumber(0.75, -1.06);
        co.division();
        
        assertEquals(expectedResult.getReal(), stack.peekFirst().getReal(), 0.01);
        assertEquals(expectedResult.getImg(), stack.peekFirst().getImg(), 0.01);
        
    }

    /**
     * Test of squareRoot method, of class ComplexOperations.
     */
    @Test
    public void testSquareRoot() {
        System.out.println("Test SQRT");
        
        ComplexNumber num1 = new ComplexNumber(11.0 , 0.3);
        
        co.insertion(num1);
        
        
        ComplexNumber expectedResult = new ComplexNumber(-3.316, -0.045);
        co.squareRoot();
        
        assertEquals(expectedResult.getReal(), stack.peekFirst().getReal(), 0.001);
        assertEquals(expectedResult.getImg(), stack.peekFirst().getImg(), 0.001);
        
    }

    /**
     * Test of invertedSign method, of class ComplexOperations.
     */
    @Test
    public void testInvertedSign() {
        System.out.println("Test InvertedSign");
        
        ComplexNumber num1 = new ComplexNumber(22.0 , 0.8);
        
        co.insertion(num1);
        
        
        ComplexNumber expectedResult = new ComplexNumber(-22.0, -0.8);
        co.invertedSign();
        
        assertEquals(expectedResult.getReal(), stack.peekFirst().getReal(), 0.001);
        assertEquals(expectedResult.getImg(), stack.peekFirst().getImg(), 0.001);
        
    }
    
}
