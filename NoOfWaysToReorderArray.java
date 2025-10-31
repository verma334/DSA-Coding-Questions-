package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.List;

public class NoOfWaysToReorderArray {

	 private static final int MOD = 1_000_000_007;
	    private long[][] comb;

	    public int numOfWays(int[] nums) {
	        int n = nums.length;
	        comb = new long[n + 1][n + 1];
	        buildCombinations(n);

	        List<Integer> list = new ArrayList<>();
	        for (int num : nums) list.add(num);

	        // Subtract 1 to exclude the original ordering
	        return (int)((countWays(list) - 1 + MOD) % MOD);
	    }

	    // Precompute combination values using Pascal's triangle
	    private void buildCombinations(int n) {
	        for (int i = 0; i <= n; i++) {
	            comb[i][0] = comb[i][i] = 1;
	            for (int j = 1; j < i; j++) {
	                comb[i][j] = (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
	            }
	        }
	    }

	    // Recursively count the number of reorderings that yield the same BST
	    private long countWays(List<Integer> nums) {
	        if (nums.size() <= 2) return 1;

	        int root = nums.get(0);
	        List<Integer> left = new ArrayList<>();
	        List<Integer> right = new ArrayList<>();

	        for (int i = 1; i < nums.size(); i++) {
	            if (nums.get(i) < root) left.add(nums.get(i));
	            else right.add(nums.get(i));
	        }

	        long leftWays = countWays(left);
	        long rightWays = countWays(right);

	        long totalWays = (comb[left.size() + right.size()][left.size()] * leftWays) % MOD;
	        totalWays = (totalWays * rightWays) % MOD;

	        return totalWays;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NoOfWaysToReorderArray solver = new NoOfWaysToReorderArray();

        // Test input: nums = [2,1,3]
        int[] nums = {2, 1, 3};
        int result = solver.numOfWays(nums);

        System.out.println("Number of ways to reorder array to get same BST: " + result);
    }
	}


