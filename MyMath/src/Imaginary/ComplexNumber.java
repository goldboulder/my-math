/*

 */
package Imaginary;


public class ComplexNumber {
    
    private double realPart;
    private double imaginaryPart;
    
    /**
     * Creates a new complex number with real and imaginary parts both equal to 0
     */
    public ComplexNumber(){
        this(0,0);
    }
    
    /**
     * Creates a new complex number with a given real part and imaginary part equal to 0
     * @param real
     */
    public ComplexNumber(double real){
        this(real,0);
    }
    
    /**
     * Creates a new complex number with real and imaginary parts
     * @param real
     * @param imag
     */
    public ComplexNumber(double real, double imag){
        realPart = real;
        imaginaryPart = imag;
    }

    /**
     * returns the real part of the complex number
     * @return the real part of the complex number
     */
    public double getRealPart() {
        return realPart;
    }

    /**
     * sets the real part of the complex number to the given value
     * @param realPart the new value
     */
    public void setRealPart(double realPart) {
        this.realPart = realPart;
    }

    /**
     * returns the imaginary part of the complex number
     * @return the imaginary part of the complex number
     */
    public double getImaginaryPart() {
        return imaginaryPart;
    }

    /**
     * sets the imaginary part of the complex number to the given value
     * @param imaginaryPart the new value
     */
    public void setImaginaryPart(double imaginaryPart) {
        this.imaginaryPart = imaginaryPart;
    }
    
    /**
     * returns the sum of the complex number and a given complex number
     * @param c
     * @return the sum of the complex number and a given complex number
     */
    public ComplexNumber sum(ComplexNumber c){
        return new ComplexNumber(realPart+c.getRealPart(),imaginaryPart+c.getImaginaryPart());
    }
    
    /**
     * adds the given complex number to this number
     * @param c
     */
    public void addToSelf(ComplexNumber c){
        realPart += c.getRealPart();
        imaginaryPart += c.getImaginaryPart();
    }
    
    /**
     * return the sum of two given complex numbers (c1 + c2)
     * @param c1
     * @param c2
     * @return the sum of c1 and c2
     */
    public static ComplexNumber add(ComplexNumber c1, ComplexNumber c2){
        return new ComplexNumber(c1.realPart + c2.realPart, c1.imaginaryPart + c2.imaginaryPart);
    }
    
    /**
     * returns the difference of the complex number and a given complex number
     * @param c
     * @return the difference of the complex number and a given complex number
     */
    public ComplexNumber difference(ComplexNumber c){
        return new ComplexNumber(realPart-c.getRealPart(),imaginaryPart-c.getImaginaryPart());
    }
    
    /**
     * subtracts the given complex number from this number
     * @param c
     */
    public void subtractFromSelf(ComplexNumber c){
        realPart -= c.getRealPart();
        imaginaryPart -= c.getImaginaryPart();
    }
    
    /**
     * return the difference of two given complex numbers (c1 - c2)
     * @param c1
     * @param c2
     * @return the difference of c1 and c2
     */
    public static ComplexNumber subtract(ComplexNumber c1, ComplexNumber c2){
        return new ComplexNumber(c1.realPart - c2.realPart, c1.imaginaryPart - c2.imaginaryPart);
    }
    
    /**
     * returns the product of the complex number and a given complex number
     * @param c
     * @return the product of the complex number and a given complex number
     */
    public ComplexNumber product(ComplexNumber c){
        return new ComplexNumber(realPart*c.realPart - imaginaryPart*c.imaginaryPart,imaginaryPart*c.realPart + realPart*c.imaginaryPart);
    }
    
    /**
     * multiplies the given complex number to this number
     * @param c
     */
    public void multiplyToSelf(ComplexNumber c){
        double realTemp = realPart;
        double imaginaryTemp = imaginaryPart;
        
        realPart = realTemp*c.realPart - imaginaryTemp*c.imaginaryPart;
        imaginaryPart = imaginaryTemp*c.realPart + realTemp*c.imaginaryPart;
    }
    
    /**
     * return the product of two given complex numbers (c1 * c2)
     * @param c1
     * @param c2
     * @return the product of c1 and c2
     */
    public static ComplexNumber multiply(ComplexNumber c1, ComplexNumber c2){
        return new ComplexNumber(c1.realPart*c2.realPart - c1.imaginaryPart*c2.imaginaryPart,c1.imaginaryPart*c2.realPart + c1.realPart*c2.imaginaryPart);
    }
    
    /**
     * returns the quotient of the complex number and a given complex number
     * @param c
     * @return the quotient of the complex number and a given complex number
     */
    public ComplexNumber quotient(ComplexNumber c){
        double realNum = realPart*c.realPart + imaginaryPart*c.imaginaryPart;
        double imagNum = imaginaryPart*c.realPart - realPart*c.imaginaryPart;
        double dem = c.realPart*c.realPart + c.imaginaryPart*c.imaginaryPart;
        
        return new ComplexNumber(realNum/dem,imagNum/dem);
    }
    
    /**
     * divides the given complex number to this number
     * @param c
     */
    public void divideToSelf(ComplexNumber c){
        double realNum = realPart*c.realPart + imaginaryPart*c.imaginaryPart;
        double imagNum = imaginaryPart*c.realPart - realPart*c.imaginaryPart;
        double dem = c.realPart*c.realPart + c.imaginaryPart*c.imaginaryPart;
        
        realPart = realNum/dem;
        imaginaryPart = imagNum/dem;
    }
    
    /**
     * return the quotient of two given complex numbers (c1 / c2)
     * @param c1
     * @param c2
     * @return the quotient of c1 and c2
     */
    public static ComplexNumber divide(ComplexNumber c1, ComplexNumber c2){
        double realNum = c1.realPart*c2.realPart + c1.imaginaryPart*c2.imaginaryPart;
        double imagNum = c1.imaginaryPart*c2.realPart - c1.realPart*c2.imaginaryPart;
        double dem = c2.realPart*c2.realPart + c2.imaginaryPart*c2.imaginaryPart;
        
        return new ComplexNumber(realNum/dem,imagNum/dem);
    }
    
    /**
     * on a rectangular coordinate system with real numbers on the x axis and
     * imaginary numbers on the y axis, returns the length of the line formed between
     * the origin and the point representing the complex number
     * @return the absolute value of the complex number
     */
    public double absoluteValue(){
        return Math.hypot(realPart, imaginaryPart);
    }
    
    /**
     * on a rectangular coordinate system with real numbers on the x axis and
     * imaginary numbers on the y axis, returns the angle formed between
     * the + x axis and the line connecting the origin and the point representing
     * the complex number
     * @return the angle of the complex number
     */
    public double angle(){
        return Math.atan2(imaginaryPart, realPart);
    }
    
    /**
     * returns the conjugate of the complex number (a + bi -> a - bi)
     * @return the conjugate of the complex number
     */
    public ComplexNumber conjugate(){
        return new ComplexNumber(realPart,-imaginaryPart);
    }
    
    /**
     * determines if the given complex number is part of the Mandelbrot Set
     * @param iterations the number of times to iterate the number to see if it
     * escapes to infinity
     * @return
     */
    public boolean inMandelbrotSet(int iterations){
        ComplexNumber z = getCopy();
        ComplexNumber c = getCopy();
        for (int i = 0; i < iterations; i++){
            if (clearlyDiverges(z)){
                return false;
            }
            else{
                z = MandelbrotIteration(z,c);
            }
        }
        return true;
    }
    
    private boolean clearlyDiverges(ComplexNumber c){
        //return c.absoluteValue() > 2;
        return c.realPart < -2 || c.realPart > 1 || c.imaginaryPart < -1 || c.imaginaryPart > 1;
    }
    
    private ComplexNumber MandelbrotIteration(ComplexNumber previous, ComplexNumber c){
        ComplexNumber square = previous.product(previous);
        return square.sum(c);
    }
    
    private ComplexNumber getCopy(){
        return new ComplexNumber(realPart,imaginaryPart);
    }
    
    @Override
    public String toString(){
        return realPart + " + " + imaginaryPart + "i";
    }
    
}
