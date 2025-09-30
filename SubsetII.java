package ArrayAndStringsDSAQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {

	public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums); // Sort to group duplicates together
        backtrack(resultList, new ArrayList<>(), nums, 0);
        return resultList;
    }

    private void backtrack(List<List<Integer>> resultSets, List<Integer> tempSet, int[] nums, int start) {
        resultSets.add(new ArrayList<>(tempSet));

        for (int i = start; i < nums.length; i++) {
            // Skip duplicates
            if (i > start && nums[i] == nums[i - 1]) continue;

            tempSet.add(nums[i]);
            backtrack(resultSets, tempSet, nums, i + 1);
            tempSet.remove(tempSet.size() - 1);
        }
    }
    
    public static void main(String[] args) {
    	SubsetII sb = new SubsetII();
    	int[] nums = {1,2,2};
    	
    	List<List<Integer>> result =sb.subsetsWithDup(nums);
    	System.out.println("subset of 2 is:"+result);
    }
}
