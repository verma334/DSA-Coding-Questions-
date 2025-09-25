package ArrayAndStringsDSAQuestions;

public class CountValidParenthesesUsingCathelan {


//////////////solved with dynamic programming///////////////////////////////////////
	    public static int countValidParentheses(int n) {
	        if (n % 2 != 0) return 0; // Odd length can't form valid parentheses

	        int k = n / 2;
	        int[] dp = new int[k + 1];
	        dp[0] = 1;

	        for (int i = 1; i <= k; i++) {
	            for (int j = 0; j < i; j++) {
	                dp[i] += dp[j] * dp[i - 1 - j];
	            }
	        }

	        return dp[k];
	    }

	    public static void main(String[] args) {
	        int n = 6;
	        System.out.println("Valid parentheses count for length " + n + ": " + countValidParentheses(n));
	    }
	

}
