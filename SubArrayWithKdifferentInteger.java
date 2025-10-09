package ArrayAndStringsDSAQuestions;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithKdifferentInteger {

	public int subarraysWithKDistinct(int[] nums, int k) {
        return findAtMostK(nums,k) - findAtMostK(nums,k-1);
    }

    private int findAtMostK(int[] nums,int k){
        Map<Integer,Integer> map = new HashMap<>();
        int count =0;
        int left = 0;
        for(int right=0;right<nums.length;right++){
            map.put(nums[right],map.getOrDefault(nums[right],0)+1);
            while(map.size() > k){
                map.put(nums[left],map.get(nums[left])-1) ;
                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }
                left++;
            }
            count += (right - left + 1);
        }
        return count;
    }

    public static void main(String[] args) {
    	SubArrayWithKdifferentInteger si = new SubArrayWithKdifferentInteger();
    	int[] nums = {1,2,1,2,3};
    	int k = 2;
    	int result = si.subarraysWithKDistinct(nums,k);
    	System.out.println("suaray with k most digfferent integr:"+result);
    }
}
