/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package scientificcalculatorapp;

import exceptions.ZeroDivisionException;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author candi
 */
public class StackOPTest {
    
    private Deque<ComplexNumber> s;
    private StackOP stack;
   
    
    @BeforeEach
    public void setUp() {
        s = new LinkedList<>();
        stack = new StackOP(s);
        
    }
    
    

    /**
     * Test of clear method, of class StackOP.
     */
    @Test
    public void testClear() {
        
        System.out.println("Test clear method: ordinary case");
        ComplexNumber num = new ComplexNumber(7,-5);
        ComplexNumber num2 = new ComplexNumber(5.345, 8.88);
        s.addFirst(num);
        s.addFirst(num2);
         
        stack.clear();
    
        assertTrue(s.isEmpty());
        
    }

    /**
     * Test of drop method, of class StackOP.
     */
    @Test
    public void testDrop() {
        System.out.println("Test drop method: ordinary case");
        ComplexNumber cn1 = new ComplexNumber(5, 8);
        ComplexNumber cn2 = new ComplexNumber(7, 10);
        s.addFirst(cn1);
        s.addFirst(cn2);
        int size = s.size();
        stack.drop();
        int sizexpected = size-1;
        assertEquals(sizexpected, s.size());
        assertEquals(cn1, s.peekFirst());

        // Checking the drop removing also the last element into the stack
        stack.drop();
        assertEquals(0, s.size());
        assertEquals(null, s.peekFirst());
    }
    
    public void testDropFail() {
        System.out.println("Test drop method: fail case");
        assertThrows(EmptyStackException.class, () -> {
             stack.drop();
        });
    }

    
    /**
     * Test of dup method, of class StackOP.
     */
    @Test
    public void testDup() {
        System.out.println("Test dup method: ordinary case");
        ComplexNumber cn = new ComplexNumber(7.4, 8.6);
        s.addFirst(cn);
        int size = s.size();
        stack.dup();
        int sizexpected = size+1;
        assertEquals(sizexpected, s.size());
        assertEquals(cn, s.peekFirst());

        // Additional check: verify if the last element is actually the copy of the second-last one
        ComplexNumber num1 = s.removeFirst();
        ComplexNumber num2 = s.removeFirst();
        assertEquals(num1, num2);
    }
    
    public void testDupFail() {
        System.out.println("Test dup method: fail case");
        assertThrows(EmptyStackException.class, () -> {
             stack.dup();
        });
    }

    /**
     * Test of swap method, of class StackOP.
     */
    @Test
    public void testSwap() {
        System.out.println("Test swap method: ordinary case");
        ComplexNumber cn1 = new ComplexNumber(3.3, 6.4);
        ComplexNumber cn2 = new ComplexNumber(8.3, 98.21);
        s.addFirst(cn1);
        s.addFirst(cn2);
        int size = s.size();
        stack.swap();
        assertEquals(size, s.size());
        assertEquals(cn1, s.peekFirst());

        // Additional check: verify the order of the swapped elements
        assertEquals(cn1, s.removeFirst());
        assertEquals(cn2, s.removeFirst());
    }
    
    
    public void testSwapFail() {
        System.out.println("Test swap method: fail case");
        assertThrows(EmptyStackException.class, () -> {
             stack.swap();
        });
    }

    /**
     * Test of over method, of class StackOP.
     */
    @Test
    public void testOver() {
        System.out.println("Test over method: ordinary case");
        ComplexNumber cn1 = new ComplexNumber(3, 3);
        ComplexNumber cn2 = new ComplexNumber(5, 5);
        s.addFirst(cn1);
        s.addFirst(cn2);
        int size = s.size();
        stack.over();
        int sizexpected = size+1;
        assertEquals(sizexpected, s.size());
        assertEquals(cn1, s.peekFirst());

        // Additional check: verify if the last element is actually the copy of the third-last one
        ComplexNumber num1 = s.removeFirst();
        ComplexNumber num2 = s.removeFirst();
        ComplexNumber num3 = s.removeFirst();
        assertEquals(num1, num3);

        // Additional check: verify the general order of the elements
        assertEquals(cn1, num1);
        assertEquals(cn2, num2);
        assertEquals(cn1, num3);
    }
    
    public void testOverFail() {
        System.out.println("Test over method: fail case");
        assertThrows(EmptyStackException.class, () -> {
             stack.over();
        });
    }
    
}
