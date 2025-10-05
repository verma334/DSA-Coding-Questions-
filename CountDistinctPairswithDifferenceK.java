package ArrayAndStringsDSAQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountDistinctPairswithDifferenceK {

	
	public static int TotalPairs(int[] nums, int k) {
        Set<Integer> seen = new HashSet<>();
        Set<String> uniquePairs = new HashSet<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
            seen.add(num);
        }

        int count = 0;

        for (int num : seen) {
            if (k == 0) {
                // Count only if there's more than one occurrence
                if (freq.get(num) > 1) {
                    count++;
                }
            } else {
                if (seen.contains(num + k)) {
                    count++;
                }
            }
        }

        return count;
    }
	
	public static void main(String[] args) {
		CountDistinctPairswithDifferenceK cd = new CountDistinctPairswithDifferenceK();
		int[] nums = {1, 5, 4, 1, 2};
		int k = 0;
		int result =cd.TotalPairs(nums,k);
		System.out.println("count pairs with differnecv K:" +result);
		
	}
}
