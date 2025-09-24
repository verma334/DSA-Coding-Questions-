package ArrayAndStringsDSAQuestions;

import java.util.List;

public class MaximumProductSubarray {

public int maxProduct(int[] nums) {
        
        int n =nums.length;
        int leftProduct = 1;
        int rightProduct = 1;
        int ans = nums[0];

        for(int i =0;i<n;i++){
            leftProduct = leftProduct == 0 ? 1 : leftProduct;
            rightProduct = rightProduct == 0 ? 1 : rightProduct;

            leftProduct *= nums[i];
            rightProduct *= nums[n-1-i];
            ans = Math.max(ans,Math.max(leftProduct,rightProduct));
        }

        return ans;

    }

public static void main(String[] args) {
	MaximumProductSubarray ma = new MaximumProductSubarray();
	int[] nums = {2,3,-2,4};
	int result = ma.maxProduct(nums);
	System.out.println("maximum product of subarray:" +result);
	
	
}
}
