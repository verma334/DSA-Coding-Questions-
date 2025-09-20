package MathQuestionsDSA;

public class CountDigits {

	static int evenlyDivides(int n) {

	    // Method to count digits that divide n evenly
	   
	        int count = 0;
	        int original = n;

	        while (n > 0) {
	            int digit = n % 10;
	            n /= 10;

	            // Skip 0 to avoid division by zero
	            if (digit != 0 && original % digit == 0) {
	                count++;
	            }
	        }

	        return count;
	    }

	    public static void main(String[] args) {
	        int n1 = 12;
	        int n2 = 2446;
	        int n3 = 23;

	        System.out.println("Digits dividing " + n1 + ": " + evenlyDivides(n1));   // Output: 2
	        System.out.println("Digits dividing " + n2 + ": " + evenlyDivides(n2));   // Output: 1
	        System.out.println("Digits dividing " + n3 + ": " + evenlyDivides(n3));   // Output: 0
}
}
