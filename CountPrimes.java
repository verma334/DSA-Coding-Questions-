package MathQuestionsDSA;

public class CountPrimes {

	
	public int countPrimes(int n) {
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }

        return count;
    }

    // Helper method to check if a number is prime
    private boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }

        return true;
    }

    // Optional main method for testing locally
    public static void main(String[] args) {
        CountPrimes sol = new CountPrimes();
        System.out.println(sol.countPrimes(10)); // Output: 4
        System.out.println(sol.countPrimes(0));  // Output: 0
        System.out.println(sol.countPrimes(1));  // Output: 0
    }
}
