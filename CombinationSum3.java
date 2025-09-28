package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum3 {

	
	 public List<List<Integer>> combinationSum3(int k, int n) {
	        List<List<Integer>> result = new ArrayList<>();
	        backtrack(k, n, 1, new ArrayList<>(), result);
	        return result;
	    }

	    private void backtrack(int k, int target, int start, List<Integer> current, List<List<Integer>> result) {
	        if (k == 0 && target == 0) {
	            result.add(new ArrayList<>(current));
	            return;
	        }
	        if (k == 0 || target < 0) return;

	        for (int i = start; i <= 9; i++) {
	            current.add(i);
	            backtrack(k - 1, target - i, i + 1, current, result);
	            current.remove(current.size() - 1); // backtrack
	        }
	    }

	    // Example usage
	    public static void main(String[] args) {
	    	CombinationSum3 solver = new CombinationSum3();
	        System.out.println("Example 1: " + solver.combinationSum3(3, 7)); // [[1,2,4]]
	        System.out.println("Example 2: " + solver.combinationSum3(3, 9)); // [[1,2,6],[1,3,5],[2,3,4]]
	        System.out.println("Example 3: " + solver.combinationSum3(4, 1)); // []
	    }
}
