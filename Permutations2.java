package ArrayAndStringsDSAQuestions;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations2 {

	public List<List<Integer>> permuteUnique(int[] nums) {
        
        
		List<List<Integer>> resultList = new ArrayList<>();
		        Arrays.sort(nums); // Sort to handle duplicates
		        boolean[] used = new boolean[nums.length];
		        backtrack(resultList, new ArrayList<>(), nums, used);
		        return resultList;

		    }


		    private void backtrack(List<List<Integer>> resultList,     ArrayList<Integer> tempList,int[] nums,boolean[] used){

		     if(tempList.size() == nums.length && !resultList.contains(tempList)){
		        resultList.add(new ArrayList<>(tempList));
		        return;
		     }
		     for(int i=0;i<nums.length;i++){
		        if(used[i])
		        continue;

		        used[i] = true;
		        tempList.add(nums[i]);

		        backtrack(resultList,tempList,nums,used);

		        used[i] = false;
		        tempList.remove(tempList.size() - 1);
		     }


		    }
		    
		    public static void main(String[] args) {
		    	Permutations2 pm = new Permutations2();
		    	int[] nums = {1,1,2};
		    	List<List<Integer>> result = pm.permuteUnique(nums);
		    	for (List<Integer> permutation : result) {
		            System.out.println(permutation);
		        }
		    }
}
