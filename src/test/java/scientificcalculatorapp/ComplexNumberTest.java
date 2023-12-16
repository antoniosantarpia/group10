/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package scientificcalculatorapp;

import exceptions.ZeroDivisionException;
import java.util.Deque;
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
 * @author Group_10
 */
public class ComplexNumberTest {
    
    private ComplexOperations complexOperation;
    private Deque<ComplexNumber> stack;
    private final double ROUND_CONSTANT = 1000.0;
    
    
    @BeforeEach
    public void setUp() {
         stack = new LinkedList<>();
        complexOperation = new ComplexOperations(stack);
    }
    
    @AfterEach
    public void tearDown() {
    }
     
    
    

    @Test
    public void testGetImg() {
        // Arrange
        double expectedImg = 2.0;
        ComplexNumber complexNumber = new ComplexNumber(1.0, expectedImg);

        // Act
        double actualImg = complexNumber.getImg();

        // Assert
        assertEquals(expectedImg, actualImg, 0.0001); // Considera una tolleranza per confronti tra double
    }

    @Test
    public void testGetReal() {
        // Arrange
        double expectedReal = 3.0;
        ComplexNumber complexNumber = new ComplexNumber(expectedReal, 2.0);

        // Act
        double actualReal = complexNumber.getReal();

        // Assert
        assertEquals(expectedReal, actualReal, 0.0001); // Considera una tolleranza per confronti tra double
    }


    
    

    /**
     * Test of add method, of class ComplexNumber.
     */
    @Test
    public void testAdd() {
        System.out.println("Testing add method: two complex numbers with both real and imaginary parts positive");
        ComplexNumber complexNumber1 = new ComplexNumber(4.0, 7.0);
        ComplexNumber complexNumber2 = new ComplexNumber(3.0, 8.0);

       
        ComplexNumber result = complexNumber1.add(complexNumber2);

        
        double expectedReal = 7.0;
        double expectedImg = 15.0;

        assertEquals(expectedReal, result.getReal()); // Tolleranza per confronti tra double
        assertEquals(expectedImg, result.getImg());
    }
    
    
     @Test
    public void testAdd1() {
        System.out.println("Testing add method: two complex numbers with both real and imaginary parts negative");
        ComplexNumber complexNumber1 = new ComplexNumber(-2.45, -67.49);
        ComplexNumber complexNumber2 = new ComplexNumber(-3.0, -4.0);

       
        ComplexNumber result = complexNumber1.add(complexNumber2);

        
        double expectedReal = -5.45;
        double expectedImg = -71.49;

        assertEquals(expectedReal, result.getReal()); // Tolleranza per confronti tra double
        assertEquals(expectedImg, result.getImg());
    }
    
    
    
     @Test
    public void testAdd2() {
         System.out.println("Testing add method: two complex numbers with both imaginary parts null");
        ComplexNumber complexNumber1 = new ComplexNumber(78.5, 0);
        ComplexNumber complexNumber2 = new ComplexNumber(-34.5, 0);

       
        ComplexNumber result = complexNumber1.add(complexNumber2);

        
        double expectedReal = 44;
        double expectedImg = 0;

        assertEquals(expectedReal, result.getReal()); // Tolleranza per confronti tra double
        assertEquals(expectedImg, result.getImg());
    
    }
    
    
     @Test
    public void testAdd3() {
         System.out.println("Testing add method: two complex numbers with both real parts null");
        ComplexNumber complexNumber1 = new ComplexNumber(0, 67.3);
        ComplexNumber complexNumber2 = new ComplexNumber(0, -87.3);

       
        ComplexNumber result = complexNumber1.add(complexNumber2);

        
        double expectedReal = 0;
        double expectedImg = -20;

        assertEquals(expectedReal, result.getReal()); // Tolleranza per confronti tra double
        assertEquals(expectedImg, result.getImg());
    
    }
    
    @Test
    public void testAdd4() {
         System.out.println("Testing add method: two complex numbers with both real parts null");
        ComplexNumber complexNumber1 = new ComplexNumber(0, 67.3);
        ComplexNumber complexNumber2 = new ComplexNumber(0, -87.3);

       
        ComplexNumber result = complexNumber1.add(complexNumber2);

        
        double expectedReal = 0;
        double expectedImg = -20;

        assertEquals(expectedReal, result.getReal()); // Tolleranza per confronti tra double
        assertEquals(expectedImg, result.getImg(), 0.0001);
    
    }
    
    
    @Test
    public void testAdd5() {
         System.out.println("Testing add method: two mix complex numbers");
        ComplexNumber complexNumber1 = new ComplexNumber(76, -67.3);
        ComplexNumber complexNumber2 = new ComplexNumber(-34, 7.6);

       
        ComplexNumber result = complexNumber1.add(complexNumber2);

        
        double expectedReal = 42;
        double expectedImg = -59.7;

        assertEquals(expectedReal, result.getReal()); // Tolleranza per confronti tra double
        assertEquals(expectedImg, result.getImg(), 0.0001);
    
    }
    

   /**
     * Test of subtract method, of class ComplexNumber.
     * method that tests the two complex numbers with both real and imaginary parts positive
     */
    @Test
    public void testSubtract() {
       System.out.println("Testing subtract method: two positive complex numbers");
        ComplexNumber complexNumber1 = new ComplexNumber(2.0, 5.0);
        ComplexNumber complexNumber2 = new ComplexNumber(1.0, 4.0);

       
        ComplexNumber result = complexNumber1.subtract(complexNumber2);

        
        double expectedReal = 1.0;
        double expectedImg = 1.0;

        assertEquals(expectedReal, result.getReal(),0.0001);
        assertEquals(expectedImg, result.getImg(),0.0001);
    }
    
    /**
     * Test of subtract method, of class ComplexNumber.
     * method that tests the two complex numbers with both real and imaginary parts negative
     */
    @Test
    public void testSubtract1() {
       System.out.println("Testing subtract method: two negative complex numbers");
        ComplexNumber complexNumber1 = new ComplexNumber(-2.0, -5.0);
        ComplexNumber complexNumber2 = new ComplexNumber(-1.0, -4.0);

       
        ComplexNumber result = complexNumber1.subtract(complexNumber2);

        
        double expectedReal = -1.0;
        double expectedImg = -1.0;

        assertEquals(expectedReal, result.getReal(),0.0001);
        assertEquals(expectedImg, result.getImg(),0.0001);
    }
    
    /**
     * Test of subtract method, of class ComplexNumber.
     * method that tests the two complex numbers with both real parts null
     */
    @Test
    public void testSubtract2() {
       System.out.println("Testing subtract method: realpart null");
        ComplexNumber complexNumber1 = new ComplexNumber(0, 15);
        ComplexNumber complexNumber2 = new ComplexNumber(0, 27.5);

       
        ComplexNumber result = complexNumber1.subtract(complexNumber2);

        
        double expectedReal = 0;
        double expectedImg = -12.5;

        assertEquals(expectedReal, result.getReal(), 0.0001);
        assertEquals(expectedImg, result.getImg(), 0.0001);
    }
    
    /**
     * Test of subtract method, of class ComplexNumber.
     * method that tests the two complex numbers with both imaginary parts null
     */
    @Test
    public void testSubtract3() {
       System.out.println("Testing subtract method: imgpart null");
        ComplexNumber complexNumber1 = new ComplexNumber(22.5, 0);
        ComplexNumber complexNumber2 = new ComplexNumber(11.0, 0);

       
        ComplexNumber result = complexNumber1.subtract(complexNumber2);

        
        double expectedReal = 11.50;
        double expectedImg = 0;

        assertEquals(expectedReal, result.getReal(),0.0001);
        assertEquals(expectedImg, result.getImg(),0.0001);
    }
    
    /**
     * Test of subtract method, of class ComplexNumber.
     * method that checks the two complex numbers considering various possibilities
     */
    @Test
    public void testSubtract4() {
       System.out.println("Testing subtract method: mix");
        ComplexNumber complexNumber1 = new ComplexNumber(0, -12);
        ComplexNumber complexNumber2 = new ComplexNumber(25.5, 11);

       
        ComplexNumber result = complexNumber1.subtract(complexNumber2);

        
        double expectedReal = -25.5;
        double expectedImg = -23;

        assertEquals(expectedReal, result.getReal(),0.0001);
        assertEquals(expectedImg, result.getImg(),0.0001);
    }

   /**
     * Test of multiply method, of class ComplexNumber.
     * method that tests integer real part and decimal imaginary part
     */
    @Test
    public void testMultiply() {
        System.out.println("Testing multiply method: integer real part and decimal imaginary part");
        ComplexNumber complexNumber1 = new ComplexNumber(-1.0, 2.5);
        ComplexNumber complexNumber2 = new ComplexNumber(-11.0, 25.7);

       
        ComplexNumber result = complexNumber1.multiply(complexNumber2);

        
        double expectedReal = -53.25;
        double expectedImg = -53.2;

        assertEquals(expectedReal, result.getReal(),0.0001);
        assertEquals(expectedImg, result.getImg(),0.0001);
        
    }
    
    /**
     * Test of multiply method, of class ComplexNumber.
     * method that tests integer imaginary part and decimal real part
     */
    @Test
    public void testMultiply1() {
        System.out.println("Testing multiply method: integer imaginary part and decimal real part");
        ComplexNumber complexNumber1 = new ComplexNumber(7.9, 1.0);
        ComplexNumber complexNumber2 = new ComplexNumber(11.23, -3.0);

       
        ComplexNumber result = complexNumber1.multiply(complexNumber2);

        
        double expectedReal = 91.717;
        double expectedImg = -12.47;

        assertEquals(expectedReal, result.getReal(),0.0001);
        assertEquals(expectedImg, result.getImg(),0.0001);
        
    }
    
    /**
     * Test of multiply method, of class ComplexNumber.
     * method that tests the two complex numbers with both real parts null
     */
    @Test
    public void testMultiply2() {
        System.out.println("Testing multiply method: realpart null");
        ComplexNumber complexNumber1 = new ComplexNumber(0, -23.2);
        ComplexNumber complexNumber2 = new ComplexNumber(0, 11.0);

       
        ComplexNumber result = complexNumber1.multiply(complexNumber2);

        
        double expectedReal = 255.2;
        double expectedImg = 0;

        assertEquals(expectedReal, result.getReal(),0.0001);
        assertEquals(expectedImg, result.getImg(),0.0001);
        
    }
    
    /**
     * Test of multiply method, of class ComplexNumber.
     * method that tests a multiplication by zero
     */
    @Test
    public void testMultiply3() {
        System.out.println("Testing multiply method: multiplication by zero");
        ComplexNumber complexNumber1 = new ComplexNumber(15, -1.2);
        ComplexNumber complexNumber2 = new ComplexNumber(0, 0);

       
        ComplexNumber result = complexNumber1.multiply(complexNumber2);

        
        double expectedReal = 0;
        double expectedImg = 0;

        assertEquals(expectedReal, result.getReal(),0.0001);
        assertEquals(expectedImg, result.getImg(),0.0001);
        
    }

    
    /**
     * Test of divide method, of class ComplexNumber.
     * method that tests integer real part and decimal imaginary part
     */
    @Test
    public void testDivide() {
    System.out.println("Testing divide method: integer real part and decimal imaginary part");
    ComplexNumber complexNumber1 = new ComplexNumber(-1.0, 9.5);
    ComplexNumber complexNumber2 = new ComplexNumber(-2.0, 0.7);

    ComplexNumber result = complexNumber2.divide(complexNumber1);

    double expectedReal = 1.92;
    double expectedImg = -4.07;

    assertEquals(expectedReal, result.getReal(), 0.01); 
    assertEquals(expectedImg, result.getImg(), 0.01);
    }
    
    
    
    /**
     * Test of divide method, of class ComplexNumber.
     * * method that tests decimal real part and integer imaginary part
     */
    @Test
    public void testDivide1() {
    System.out.println("Testing divide method: decimal real part and integer imaginary part");
    ComplexNumber complexNumber1 = new ComplexNumber(-22.3, 5.0);
    ComplexNumber complexNumber2 = new ComplexNumber(-2.6, 1.0);

    ComplexNumber result = complexNumber2.divide(complexNumber1);

    double expectedReal = 8.11;
    double expectedImg = 1.19;

    assertEquals(expectedReal, result.getReal(), 0.01); 
    assertEquals(expectedImg, result.getImg(), 0.01);
    }
    
    
    
   /**
     * Test of divide method, of class ComplexNumber.
     * method that test division by 0
     */
    public void testDivide2() {
       System.out.println("Testing divide method: division by zero");
       ComplexNumber complexNumber1 = new ComplexNumber(-19, 5.2);
       ComplexNumber complexNumber2 = new ComplexNumber(0, 0);
       ComplexNumber result = complexNumber2.divide(complexNumber1);
       
        assertThrows(ZeroDivisionException.class, () -> {
            complexNumber2.divide(complexNumber1);
        });

    }
   
    
    /**
     * Test of divide method, of class ComplexNumber.
     * method that tests the two complex numbers with both real parts null
     */
    @Test
    public void testDivide3() {
    System.out.println("Testing divide method: realpart null");
    ComplexNumber complexNumber1 = new ComplexNumber(0, -9.0);
    ComplexNumber complexNumber2 = new ComplexNumber(0, 1.7);

    ComplexNumber result = complexNumber2.divide(complexNumber1);

    double expectedReal = -5.29;
    double expectedImg = -0.0;

    assertEquals(expectedReal, result.getReal(), 0.01); // Regola la precisione a 0.01
    assertEquals(expectedImg, result.getImg(), 0.01);
    }
    
    
    
    
    /**
     * Test of sqrt method, of class ComplexNumber.
     * method that tests the two complex numbers with both real parts positive
     */
    @Test
    public void testSqrt(){
        System.out.println("Testing sqrt method: positive real and imaginary parts");
        ComplexNumber complexNumber1 = new ComplexNumber(33.57, 31.77);
        
        ComplexNumber result = complexNumber1.sqrt();
        
        double expectedReal = 6.31;
        double expectedImg = 2.51;
        
        assertEquals(expectedReal, result.getReal(), 0.01); // Regola la precisione a 0.01
        assertEquals(expectedImg, result.getImg(), 0.01);
    }
    
    /**
     * Test of sqrt method, of class ComplexNumber.
     * method that tests the two complex numbers with both real parts negative
     */
    @Test
    public void testSqrt1(){
        System.out.println("Testing sqrt method: negative real and imaginary parts");
        ComplexNumber complexNumber1 = new ComplexNumber(-21.18, -54.17);
        
        ComplexNumber result = complexNumber1.sqrt();
        
        double expectedReal = 4.30;
        double expectedImg = -6.29;
        
        assertEquals(expectedReal, result.getReal(), 0.01); // Regola la precisione a 0.01
        assertEquals(expectedImg, result.getImg(), 0.01);
    }
    
     /**
     * Test of sqrt method, of class ComplexNumber.
     * method that tests the two complex numbers with zero real part
     */
    @Test
    public void testSqrt2(){
        System.out.println("Testing sqrt method: only positive immaginary part");
        ComplexNumber complexNumber1 = new ComplexNumber(0.0, 32);
        
        ComplexNumber result = complexNumber1.sqrt();
        
        double expectedReal = 4.00;
        double expectedImg = 4.00;
        
        assertEquals(expectedReal, result.getReal(), 0.001); 
        assertEquals(expectedImg, result.getImg(), 0.001);
    }
    
    /**
     * Test of sqrt method, of class ComplexNumber.
     * method that tests the two complex numbers with zero imaginary part
     */
    @Test
    public void testSqrt3(){
        System.out.println("Testing sqrt method: only real positive part");
        ComplexNumber complexNumber1 = new ComplexNumber(11.0, 0.0);
        
        ComplexNumber result = complexNumber1.sqrt();
        ComplexNumber result1 = result.inv();
        
        double expectedReal = 3.31;
        double expectedImg = 0.0;
        double expectedReal1 = -3.31;
        double expectedImg1 = 0.0;
        
        assertEquals(expectedReal, result.getReal(), 0.01);
        assertEquals(expectedImg, result.getImg(), 0.01);
        
        assertEquals(expectedReal1, result1.getReal(), 0.01);
        assertEquals(expectedImg1, result1.getImg(), 0.01);
    }
    
    /**
     * Test of inv method, of class ComplexNumber.
     */
    @Test
    public void testInv() {
        System.out.println("Testing sign inversion");
        ComplexNumber complexNumber1 = new ComplexNumber(6, -9);
        

       
        ComplexNumber result = complexNumber1.inv();

        
        double expectedReal = -6 ;
        double expectedImg = 9;

        assertEquals(expectedReal, result.getReal(), 0.0001);
        assertEquals(expectedImg, result.getImg(), 0.0001);
        
    
        
    }
    
    
    @Test
    public void testInv1() {
        System.out.println("Testing sign inversion: negative real part and positive imaginary");
        ComplexNumber complexNumber1 = new ComplexNumber(-8.65, 9.43);
        

       
        ComplexNumber result = complexNumber1.inv();

        
        double expectedReal = 8.65;
        double expectedImg = -9.43;

        assertEquals(expectedReal, result.getReal(), 0.0001);
        assertEquals(expectedImg, result.getImg(), 0.0001);
    }
    
    @Test
    public void testInv2(){
        System.out.println("Testing sign inversion: zero real part");
        ComplexNumber complexNumber1 = new ComplexNumber(0,4.5);
        
        ComplexNumber result = complexNumber1.inv();
        
        double expectedReal = 0;
        double expectedImg = -4.5;

        assertEquals(expectedReal, result.getReal(), 0.0001);
        assertEquals(expectedImg, result.getImg(), 0.0001);
    }
   
    
    @Test
    public void testInv3(){
        System.out.println("Testing sign inversion: zero imaginary part");
        ComplexNumber complexNumber1 = new ComplexNumber(-3.4,0);
        
        ComplexNumber result = complexNumber1.inv();
        
        double expectedReal = 3.4;
        double expectedImg = 0;

        assertEquals(expectedReal, result.getReal(), 0.0001);
        assertEquals(expectedImg, result.getImg(), 0.0001);
    }
   
}
