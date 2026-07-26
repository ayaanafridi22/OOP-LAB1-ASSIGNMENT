public class Main {
      public static void main(String[] args) {
        calculator calc = new calculator();
 
        System.out.println("Add: " + calc.add(5, 3));
        System.out.println("Subtract: " + calc.subtract(5, 3));
        System.out.println("Multiply: " + calc.multiply(5, 3));
        System.out.println("Divide: " + calc.divide(6, 3));
 
        try {
            calc.divide(6, 0);
        } catch (ArithmeticException e) {
            System.out.println("Divide by zero caught: " + e.getMessage());
        }
 
        System.out.println("Power (2^10): " + calc.power(2, 10));
        System.out.println("Power edge (5^0): " + calc.power(5, 0));
 
        System.out.println("Modulus: " + calc.modulus(10, 3));
        try {
            calc.modulus(10, 0);
        } catch (ArithmeticException e) {
            System.out.println("Modulus by zero caught: " + e.getMessage());
        }
 
        double[] dataset = {4, 8, 15, 16, 23, 42};
        System.out.println("Sum: " + calc.sumAll(dataset));
        System.out.println("Average: " + calc.average(dataset));

    
 
        
        
 
        try {
            calc.average(new double[0]);
        } catch (IllegalArgumentException e) {
            System.out.println("Average of nothing caught: " + e.getMessage());
        }
    }
}
    

