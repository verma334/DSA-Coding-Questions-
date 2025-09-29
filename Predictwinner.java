package ArrayAndStringsDSAQuestions;

public class Predictwinner {

	public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];

        // Base case: when i == j, only one number to pick
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        // Fill DP table for subarrays of increasing length
        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                // Choose the best between picking start or end
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }

        // If score difference is >= 0, Player 1 can win or tie
        return dp[0][n - 1] >= 0;
    }
	
	public static void main(String[] args) {
		Predictwinner pw = new Predictwinner();
		int[] nums = {1,5,2};
		boolean result = pw.predictTheWinner(nums);
		System.out.println("Predict winner:"+result);
		
	}
}
