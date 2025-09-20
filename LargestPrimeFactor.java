package MathQuestionsDSA;

public class LargestPrimeFactor {

	
	static int largestPrimeFactor(int n) {
        int largest = -1;

        // Remove all factors of 2
        while (n % 2 == 0) {
            largest = 2;
            n /= 2;
        }

        // Check for odd factors
        for (int i = 3; i <= Math.sqrt(n); i += 2) {
            while (n % i == 0) {
                largest = i;
                n /= i;
            }
        }

        // If n is still a prime number greater than 2
        if (n > 2) {
            largest = n;
        }

        return largest;
    }

    // You can include a main method to test it
    public static void main(String[] args) {
        int[] testCases = {5, 24, 13195};
        for (int n : testCases) {
            System.out.println("Largest prime factor of " + n + " is: " + largestPrimeFactor(n));
        }
    }
}
