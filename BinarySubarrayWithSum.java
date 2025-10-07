package ArrayAndStringsDSAQuestions;

import java.util.HashMap;
import java.util.Map;

public class BinarySubarrayWithSum {

	 public int numSubarraysWithSum(int[] nums, int goal) {
	        Map<Integer,Integer> map = new HashMap<>();
	        int count =0;
	        int sum =0;
	        for(int num : nums){
	          sum = sum+num;
	          if(sum == goal){
	            count++;
	          }

	          if(map.containsKey(sum-goal)){
	           count += map.get(sum-goal);
	          }
	          map.put(sum,map.getOrDefault(sum,0)+1);
	        }
	        return count;
	    }
	 
	 public static void main(String[] args) {
		 BinarySubarrayWithSum bs = new BinarySubarrayWithSum();
		 int[] nums = {1,0,1,0,1};
		 int goal = 2;
		 int result =bs.numSubarraysWithSum(nums,goal);
		 System.out.println("binary subaaray:"+result);
		 
	 }
}
