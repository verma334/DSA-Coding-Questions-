package ArrayAndStringsDSAQuestions;

class CountGoodNumbers{
    // Define the modulo constant to avoid overflow
    int M = 1_000_000_007;

    // Main method to count good digit strings of length n
    public int countGoodNumbers(long n) {
        // Count of even indices (0-based): positions 0, 2, 4, ...
        long even = (n + 1) / 2;

        // Count of odd indices: positions 1, 3, 5, ...
        long odd = n / 2;

        // Total combinations: 5 choices for even positions, 4 for odd
        long result = (pow(5, even) * pow(4, odd)) % M;

        // Return result as integer
        return (int) result;
    }

    // Recursive modular exponentiation function: computes (a^b) % M
    private long pow(long a, long b) {
        // Base case: any number to power 0 is 1
        if (b == 0) {
            return 1;
        }

        // If exponent is even: use (a^2)^(b/2)
        if (b % 2 == 0) {
            return pow((a * a) % M, b / 2) % M;
        } else {
            // If exponent is odd: reduce by 1 and multiply by a
            return (a * pow(a, b - 1)) % M;
        }
    }
    
    public static void main(String[] args) {
    	CountGoodNumbers cg = new CountGoodNumbers();
    	int n =1;
    	int result =cg.countGoodNumbers(n);
    	System.out.println("count good numbers:"+result);
    }
}
