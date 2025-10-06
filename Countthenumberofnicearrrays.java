package ArrayAndStringsDSAQuestions;

import java.util.HashMap;

public class Countthenumberofnicearrrays {

	public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum = sum + nums[i] % 2;
            if(map.containsKey(sum-k)){
                count = count + map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }

        return count;

    }
	
	public static void main(String[] args) {
		Countthenumberofnicearrrays cn = new Countthenumberofnicearrrays();
		int[] nums = {1,1,2,1,1};
		int k = 3;
		int result = cn.numberOfSubarrays(nums,k);
		System.out.println("count number of nice array:"+result);
	}
}
