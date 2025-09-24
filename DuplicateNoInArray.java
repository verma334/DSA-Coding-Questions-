package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;

import java.util.List;

public class DuplicateNoInArray {

public List<Integer> findDuplicates(int[] nums) {
        
        List<Integer> result = new ArrayList<>();
        for(int n : nums){
            n = Math.abs(n);
            if(nums[n-1] > 0){
                nums[n -1] = nums[n -1] * -1;
            }else{
                result.add(n);
            }
        }
        return result;
}

public static void main(String[] args) {
	DuplicateNoInArray da = new DuplicateNoInArray();
	int[] nums = {4,3,2,7,8,2,3,1};
	List<Integer> result = da.findDuplicates(nums);
	System.out.println("dupliacte elements:" +result);
	
	
}
}
