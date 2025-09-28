package ArrayAndStringsDSAQuestions;

public class PowerOfX {

	
	 // Main method to calculate x raised to the power n
    public double myPow(double x, int n) {
        // Convert n to long to safely handle Integer.MIN_VALUE (-2^31)
        long N = n;

        // If exponent is negative, invert x and make exponent positive
        if (N < 0) {
            x = 1 / x;   // x^(-n) = 1 / x^n
            N = -N;
        }

        // Call the helper method to compute power recursively
        return fastPow(x, N);
    }

    // Helper method using fast exponentiation (divide and conquer)
    private double fastPow(double x, long n) {
        // Base case: any number raised to power 0 is 1
        if (n == 0) return 1.0;

        // Recursively compute x^(n/2)
        double half = fastPow(x, n / 2);

        // If n is even: x^n = (x^(n/2))^2
        if (n % 2 == 0) {
            return half * half;
        } 
        // If n is odd: x^n = (x^(n/2))^2 * x
        else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
    	PowerOfX px = new PowerOfX();
    	double x = 2.00000;
    	int n = 10;
    	System.out.println("Number raised to power: " + px.myPow(x, n));
    }
}
