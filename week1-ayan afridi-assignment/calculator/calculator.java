public class calculator {
 
    public double add(double a, double b) {
        return a + b;
    }
 
    public double subtract(double a, double b) {
        return a - b;
    }
 
    public double multiply(double a, double b) {
        return a * b;
    }
 
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero is not allowed.");
        }
        return a / b;
    }
 
    public double modulus(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Modulus by zero is not allowed.");
        }
        return a % b;
    }
 
    public double power(double base, double exponent) {
        int wholeExponent = (int) Math.abs(exponent);
        boolean isWholeNumber = exponent == wholeExponent;
 
        if (!isWholeNumber) {
            return Math.pow(base, exponent); // fractional exponent fallback
        }
 
        double result = 1;
        for (int i = 0; i < wholeExponent; i++) {
            result *= base;
        }
        return exponent < 0 ? 1 / result : result;
    }
 
    public double sumAll(double[] values) {
        double total = 0;
        for (double value : values) {
            total += value;
        }
        return total;
    }
 
    public double average(double[] values) {
        if (values.length == 0) {
            throw new IllegalArgumentException("At least one value is required.");
        }
        return sumAll(values) / values.length;
    }
 
   
            
}