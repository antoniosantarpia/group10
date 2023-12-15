/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package scientificcalculatorapp;

import exceptions.ZeroDivisionException;

/**
 *
 * @author Group_10
 */
public class ComplexNumber {
    double img;
    double real;

    
     /**
     * Constructor
     *
     * @param img is the immaginary part of complex numbers
     * @param real is the real part of complex numbers
     */
    
     public ComplexNumber(double real, double img) {
        this.real = real;
        this.img = img;
    }

    public double getImg() {
        return img;
    }


    public double getReal() {
        return real;
    }


    
     /**
     * This method allows to sum two complex number.
     *
     * @param op1
     * @return the sum of current complex number and op1
     */
    public ComplexNumber add(ComplexNumber op1) {
        double r = this.real + op1.real;
        double i = this.img + op1.img;
        
        return new ComplexNumber(r, i);
    }
    
    
     /**
     * This method allows to subtract two complex number.
     *
     * @param op1
     * @return the subtract of current complex number and op1
     */
    public ComplexNumber subtract(ComplexNumber op1) {
        double r = this.real - op1.real;
        double i = this.img - op1.img;
        
        return new ComplexNumber(r, i);
    }
    
    
    /**
     * This method allows to multiply two complex number.
     *
     * @param op1
     * @return the multiply of current complex number and op1
     */
    public ComplexNumber multiply(ComplexNumber op1) {
      return new ComplexNumber(real * op1.real - img * op1.img, real * op1.img + img*op1.real); 
    }
    
    /**
     * This method allows to divide two complex number.
     *
     * @param op2
     * @return the division of current complex number and op1
     */
    public ComplexNumber divide(ComplexNumber op2) {
        ComplexNumber divisor = this;
        ComplexNumber dividend = op2;
        
    /* Check that the divisor is not zero to avoid division by zero */
    if (divisor.getReal() == 0 && divisor.getImg() == 0) {
        throw new ZeroDivisionException();
    }

    /* Use the correct formula for dividing complex numbers */
    double divisorSquared = divisor.getReal() * divisor.getReal() + divisor.getImg() * divisor.getImg();
    
    if (divisorSquared == 0) {
        throw new ZeroDivisionException();
    }
    double realQuotient = (dividend.getReal() * divisor.getReal() + dividend.getImg() * divisor.getImg()) / divisorSquared;
    double imgQuotient = (dividend.getImg() * divisor.getReal() - dividend.getReal() * divisor.getImg()) / divisorSquared;

         return new ComplexNumber(realQuotient, imgQuotient);
    }
    
    
    /**
     * This method allows to invert sign of a complex number.
     *
     * @return number inverted of sign
     */
    public ComplexNumber inv() {
        
        return new ComplexNumber(-this.getReal(), -this.getImg());
    }
    
    
    /**
     * This method allows to calculate sqrt of a complex number.
     *
     * @return sqrt result
     */
    public ComplexNumber sqrt() {
        double r = Math.sqrt(Math.pow(real, 2) + Math.pow(img, 2));
        // Calcolo dell'angolo theta
        double theta = Math.atan2(img, real);
        // Calcolo della radice quadrata usando la formula di De Moivre
        double sqrtR = Math.sqrt(r);
        double resultReal = sqrtR * Math.cos(theta / 2);
        double resultImaginary = sqrtR * Math.sin(theta / 2);
        return new ComplexNumber(resultReal, resultImaginary);
    }
    
    @Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    ComplexNumber other = (ComplexNumber) obj;
    return Double.compare(other.real, real) == 0 &&
           Double.compare(other.img, img) == 0;
}

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.img) ^ (Double.doubleToLongBits(this.img) >>> 32));
        hash = 47 * hash + (int) (Double.doubleToLongBits(this.real) ^ (Double.doubleToLongBits(this.real) >>> 32));
        return hash;
    }

    @Override
    public String toString() {
        return "ComplexNumber{" + "img=" + img + ", real=" + real + '}';
    }
    
    
}