/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package scientificcalculatorapp;

import exceptions.NullVariableException;
import exceptions.VarOutOfRangeException;
import java.util.Deque;
import java.util.EmptyStackException;
import java.util.LinkedList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author CWS
 */
public class VariablesTest {
    private Deque <ComplexNumber> stack;
    private Variables var;
    
    @BeforeEach
    public void setUp() {
        stack = new LinkedList<>();
        var = new Variables(stack);
    }
    
    @Test
    public void testAssigntoVar() {
        System.out.println("Test assignToVar method");
        ComplexNumber complexNumber1 = new ComplexNumber(-35.17, 46.87);
        ComplexNumber complexNumber2 = new ComplexNumber(94.15,-85.21);
        stack.addFirst(complexNumber1);
        stack.addFirst(complexNumber2);
        int s1 = stack.size();
        var.assigntoVar('a');
        
        assertEquals(s1-1,stack.size());
        assertEquals(complexNumber1, stack.peekFirst());
        
        var.recoveryFromVar('a');
        assertEquals(complexNumber2,stack.peekFirst());
    }
    
    @Test
    public void testAssigntoVar1() {
        System.out.println("Test assignToVar method");
        ComplexNumber complexNumber1 = new ComplexNumber(-35.17, 46.87);
        ComplexNumber complexNumber2 = new ComplexNumber(94.15,-85.21);
        stack.addFirst(complexNumber1);
        stack.addFirst(complexNumber2);
        int s1 = stack.size();
        var.assigntoVar('a');
        
        assertEquals(s1-1,stack.size());
        assertEquals(complexNumber1, stack.peekFirst());
        
        var.assigntoVar('b');
        
        assertEquals(0, stack.size());
        assertEquals(null, stack.peekFirst());

        var.recoveryFromVar('a');
        assertEquals(complexNumber2, stack.peekFirst());

        var.recoveryFromVar('b');
        assertEquals(complexNumber1, stack.peekFirst());
    }
    
    @Test
    public void testAssigntoVar2() {
        System.out.println("Test assignToVar method");
        for (int i = 0; i < 26; i++) {
            stack.addFirst(new ComplexNumber(i,0));
        }

        for (char c = 'a'; c <= 'z'; c++) {
            var.assigntoVar(c);
        }

        assertEquals(0, stack.size());

        for (char c = 'a'; c <= 'z'; c++) {
            var.recoveryFromVar(c);
        }

        assertEquals(52, stack.size());

        for (int i = 0; i < 26; i++) {
            assertEquals(new ComplexNumber(i,0), stack.removeFirst());
        }
    }
    
    @Test
    public void assignToVarTestFail() {
        System.out.println("Test assignToVarFail method");
        assertThrows(EmptyStackException.class, () -> {
            var.assigntoVar('a');
        });
    }
    
    @Test
    public void assignToVarTestFail1() {
        System.out.println("Test assignToVarFail method");
        ComplexNumber complexNumber1 = new ComplexNumber(94.15,-85.21);
        stack.addFirst(complexNumber1);
        assertThrows(VarOutOfRangeException.class, () -> {
            var.assigntoVar('/');
        });
    }
    
    @Test
    public void assignToVarTestFail2(){
        System.out.println("Test assignToVarFail method");
        ComplexNumber complexNumber1 = new ComplexNumber(94.15,-85.21);
        stack.addFirst(complexNumber1);
        assertThrows(VarOutOfRangeException.class, () -> {
            var.assigntoVar('{');
        });
    }
    
    @Test
    public void assignToVarTestFail3(){
        System.out.println("Test assignToVarFail method");
        ComplexNumber complexNumber1 = new ComplexNumber(94.15,-85.21);
        stack.addFirst(complexNumber1);
        assertThrows(VarOutOfRangeException.class, () -> {
            var.assigntoVar('A');
        });
    }
    
    @Test
    public void assignToVarTestFail4(){
        System.out.println("Test assignToVarFail method");
        ComplexNumber complexNumber1 = new ComplexNumber(94.15,-85.21);
        stack.addFirst(complexNumber1);
        assertThrows(VarOutOfRangeException.class, () -> {
            var.assigntoVar('à');
        });
    }
    
    @Test
    public void assignToVarTestFail5(){
        System.out.println("Test assignToVarFail method");
        ComplexNumber complexNumber1 = new ComplexNumber(94.15,-85.21);
        stack.addFirst(complexNumber1);
        assertThrows(VarOutOfRangeException.class, () -> {
            var.assigntoVar('1');
        });
    }
    
    @Test
    public void testRecoveryFromVar() {
        System.out.println("Test recoveryFromVar method");
       ComplexNumber complexNumber1 = new ComplexNumber(3, 3);
        ComplexNumber complexNumber2 = new ComplexNumber(3, 5);
        stack.addFirst(complexNumber1);
        stack.addFirst(complexNumber2);
        var.assigntoVar('a');
        int s1 = stack.size();

        // Checking if an element has effectively been added to stack and if it is the correct one
        var.recoveryFromVar('a');
        assertEquals(s1 + 1, stack.size());
        assertEquals(complexNumber2, stack.peekFirst());

        // Checking if after the editing of the value copied from the variable, the value contained in the variable is unchanged
        ComplexNumber complexNumber2mod = stack.removeFirst().add(new ComplexNumber(1,0));
        stack.addFirst(complexNumber2mod);

        var.recoveryFromVar('a');
        assertEquals(s1 + 2, stack.size());
        assertEquals(complexNumber2, stack.peekFirst());

        // Checking if after adding a new value to the stack and assigning it to the variable, the stack content is unchanged
        stack.addFirst(new ComplexNumber(1,1));
        var.assigntoVar('a');
        assertEquals(new ComplexNumber(3,5), stack.removeFirst());
        assertEquals(new ComplexNumber(4, 5), stack.removeFirst());
        assertEquals(new ComplexNumber(3, 3), stack.removeFirst());
    }  
    
    @Test
     public void testRecoveryFromVarFail() {
         System.out.println("Test recoveryFromVarFail method");
         assertThrows(NullVariableException.class, () -> {
            var.recoveryFromVar('a');
        });
    }
     
     @Test
     public void testRecoveryFromVarFail1() {
         System.out.println("Test recoveryFromVarFail method");
         assertThrows(VarOutOfRangeException.class, () -> {
            var.recoveryFromVar('/');
        });
    }
     
     @Test
     public void testRecoveryFromVarFail2() {
         System.out.println("Test recoveryFromVarFail method");
         assertThrows(VarOutOfRangeException.class, () -> {
            var.recoveryFromVar('{');
        });
    }
     
     @Test
     public void testRecoveryFromVarFail3() {
         System.out.println("Test recoveryFromVarFail method");
         assertThrows(VarOutOfRangeException.class, () -> {
            var.recoveryFromVar('A');
        });
    }
     
     @Test
     public void testRecoveryFromVarFai4() {
         System.out.println("Test recoveryFromVarFail method");
         assertThrows(VarOutOfRangeException.class, () -> {
            var.recoveryFromVar('à');
        });
    }
     
     @Test
     public void testRecoveryFromVarFail5() {
         System.out.println("Test recoveryFromVarFail method");
         assertThrows(VarOutOfRangeException.class, () -> {
            var.recoveryFromVar('1');
        });
    }

    @Test
    public void testSumToVar() {
        System.out.println("Test sumToVar method");
        ComplexNumber complexNumber1 = new ComplexNumber(31, 40);
        ComplexNumber complexNumber2 = new ComplexNumber(56, 21);
        stack.addFirst(complexNumber1);
        stack.addFirst(complexNumber2);
        var.assigntoVar('a');
        int s1 = stack.size();

        // Checking if an element has effectively been removed from the stack and if the sum has been done correctly
        var.sumtoVar('a');
        assertEquals(s1 - 1, stack.size());
        var.recoveryFromVar('a');
        assertEquals(s1, stack.size());
        assertEquals(new ComplexNumber(87, 61), stack.peekFirst());

        // Checking if recalling the sumToVar method, the previous result hasn't changed
        stack.addFirst(new ComplexNumber(1,0));
        var.sumtoVar('a');
        assertEquals(new ComplexNumber(87, 61), stack.peekFirst());
    }
    
    @Test
    public void testSumToVar2() {
        System.out.println("Test sumToVar method");
        for (int i = 0; i < 26; i++) {
            stack.addFirst(new ComplexNumber(i,0));
        }


        for (char c = 'a'; c <= 'z'; c++) {
            var.assigntoVar(c);
        }

        assertEquals(26, stack.size());

        for (char c = 'a'; c <= 'z'; c++) {
            var.sumtoVar(c);
        }

        assertEquals(0, stack.size());

        for (char c = 'a'; c <= 'z'; c++) {
            var.recoveryFromVar(c);
        }

        assertEquals(26, stack.size());

        for (int i = 0; i < 26; i++) {
            assertEquals(new ComplexNumber(i * 2,0), stack.removeFirst());
        }
    }

    @Test
    public void testSumToVarFail() {
        System.out.println("Test sumToVarFail method");
        ComplexNumber complexNumber1 = new ComplexNumber(37.11, 56.54);
        stack.addFirst(complexNumber1);
        var.assigntoVar('a');
        assertThrows(EmptyStackException.class, () -> {
            var.sumtoVar('a');
        });
    }
    
    @Test
    public void testSumToVarFail1() {
        System.out.println("Test sumToVarFail method");
        ComplexNumber complexNumber1 = new ComplexNumber(37.11, 56.54);
        stack.addFirst(complexNumber1);
        assertThrows(NullVariableException.class, () -> {
            var.sumtoVar('a');
        });
    }
    
    @Test
    public void testSumToVarFail2() {
        System.out.println("Test sumToVarFail method");
        assertThrows(VarOutOfRangeException.class, () -> {
            var.sumtoVar('/');
        });
    }
    
    @Test
    public void testSumToVarFail3() {
        System.out.println("Test sumToVarFail method");
        assertThrows(VarOutOfRangeException.class, () -> {
            var.sumtoVar('{');
        });
    }
    
    @Test
    public void testSumToVarFail4() {
        System.out.println("Test sumToVarFail method");
        assertThrows(VarOutOfRangeException.class, () -> {
            var.sumtoVar('A');
        });
    }
    
    @Test
    public void testSumToVarFail5() {
        System.out.println("Test sumToVarFail method");
        assertThrows(VarOutOfRangeException.class, () -> {
            var.sumtoVar('à');
        });
    }
    
    @Test
    public void testSumToVarFail6() {
        System.out.println("Test sumToVarFail method");
        assertThrows(VarOutOfRangeException.class, () -> {
            var.sumtoVar('1');
        });
    }
    
    @Test
    public void testSubtractToVar() {
        System.out.println("Test subtractToVar method");
        ComplexNumber complexNumber1 = new ComplexNumber(31, 24);
        ComplexNumber complexNumber2 = new ComplexNumber(11, 54);
        stack.addFirst(complexNumber1);
        stack.addFirst(complexNumber2);
        var.assigntoVar('a');
        int s1 = stack.size();

        // Checking if an element has effectively been removed from the stack and if the subtraction has been done correctly
        var.subtracttoVar('a');
        assertEquals(s1 - 1, stack.size());
        var.recoveryFromVar('a');
        assertEquals(s1, stack.size());
        assertEquals(new ComplexNumber(-20, 30), stack.peekFirst());

        // Checking if recalling the subtractToVar method, the previous result hasn't changed
        stack.addFirst(new ComplexNumber(1,0));
        var.subtracttoVar('a');
        assertEquals(new ComplexNumber(-20, 30), stack.peekFirst());
    }  
    
    @Test
    public void testSubtractToVar1() {
        System.out.println("Test subtractToVar method");
        for (int i = 0; i < 26; i++) {
            stack.addFirst(new ComplexNumber(i,0));
        }

        for (int i = 0; i < 26; i++) {
            stack.addFirst(new ComplexNumber(i+1,0));
        }

        for (char c = 'a'; c <= 'z'; c++) {
            var.assigntoVar(c);
        }

        assertEquals(26, stack.size());

        for (char c = 'a'; c <= 'z'; c++) {
            var.subtracttoVar(c);
        }

        assertEquals(0, stack.size());

        for (char c = 'a'; c <= 'z'; c++) {
            var.recoveryFromVar(c);
        }

        assertEquals(26, stack.size());

        for (int i = 0; i < 26; i++) {
            assertEquals(new ComplexNumber(1,0), stack.removeFirst());
        }
    }
    
    @Test
    public void testSubtractToVarFail(){
        System.out.println("Test subtractToVarFail method");
        ComplexNumber complexNumber1 = new ComplexNumber(37.11, 56.54);
        stack.addFirst(complexNumber1);
        var.assigntoVar('a');
        assertThrows(EmptyStackException.class, () -> {
            var.subtracttoVar('a');
        });
    }
    
    @Test
    public void testSubtractToVarFail1() {
        System.out.println("Test sumToVarFail method");
        ComplexNumber complexNumber1 = new ComplexNumber(37.11, 56.54);
        stack.addFirst(complexNumber1);
        assertThrows(NullVariableException.class, () -> {
            var.subtracttoVar('a');
        });
    }
    
    @Test
    public void testSubtractToVarFail2() {
        System.out.println("Test sumToVarFail method");
        assertThrows(VarOutOfRangeException.class, () -> {
            var.subtracttoVar('/');
        });
    }
    
    @Test
    public void testSubtractToVarFail3() {
        System.out.println("Test sumToVarFail method");
        assertThrows(VarOutOfRangeException.class, () -> {
            var.subtracttoVar('{');
        });
    }
    
    @Test
    public void testSubtractToVarFail4() {
        System.out.println("Test sumToVarFail method");
        assertThrows(VarOutOfRangeException.class, () -> {
            var.subtracttoVar('A');
        });
    }
    
    @Test
    public void testSubtractToVarFail5() {
        System.out.println("Test sumToVarFail method");
        assertThrows(VarOutOfRangeException.class, () -> {
            var.subtracttoVar('à');
        });
    }
    
    @Test
    public void testSubtractToVarFail6() {
        System.out.println("Test sumToVarFail method");
        assertThrows(VarOutOfRangeException.class, () -> {
            var.subtracttoVar('1');
        });
    }
}


