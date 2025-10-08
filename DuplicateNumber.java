package ArrayAndStringsDSAQuestions;

import java.util.HashMap;

public class DuplicateNumber {

	public int findDuplicate(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return nums[i];
            }else{
                map.put(nums[i],i);
            }
        }

        return -1;
    }
	
	public static void main(String[] args) {
		DuplicateNumber dn = new DuplicateNumber();
		int[] nums= {1,3,4,2,2};
		int result =dn.findDuplicate(nums);
		System.out.println("duliate numebr:"+result);
	}
}
