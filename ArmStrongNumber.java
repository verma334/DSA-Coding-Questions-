package MathQuestionsDSA;

public class ArmStrongNumber {

	
	 static boolean armstrongNumber(int n) {
	        int original = n;
	        int sum = 0;

	        while (n > 0) {
	            int digit = n % 10;         // Get the last digit
	            sum += digit * digit * digit; // Add cube of the digit
	            n /= 10;                    // Remove the last digit
	        }

	        return sum == original; // Check if sum of cubes equals original number
	    }

	    public static void main(String[] args) {
	        int n1 = 153;
	        int n2 = 372;
	        int n3 = 100;

	        System.out.println(n1 + " is Armstrong " + armstrongNumber(n1)); // true
	        System.out.println(n2 + " is Armstrong " + armstrongNumber(n2)); // false
	        System.out.println(n3 + " is Armstrong " + armstrongNumber(n3)); // false
	    }
}
