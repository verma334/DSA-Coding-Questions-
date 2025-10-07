package ArrayAndStringsDSAQuestions;

public class MaxConsecuticeOnes {

	 public int longestOnes(int[] nums, int k) {
	        int zeroCount = 0;
	        int start = 0;
	        int max_ones = 0;

	        for (int end = 0; end < nums.length; end++) {
	            if (nums[end] == 0) {
	                zeroCount++;
	            }

	            while (zeroCount > k) {
	                if (nums[start] == 0) {
	                    zeroCount--;
	                }
	                start++;
	            }

	            max_ones = Math.max(max_ones, end - start + 1);
	        }

	        return max_ones; // ✅ Now correctly placed inside the method
	    }
	 public static void main(String[] args) {
		 MaxConsecuticeOnes mc = new MaxConsecuticeOnes();
		 int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
		 int k = 2;
		 int result = mc.longestOnes(nums,k);
		 System.out.println("maxx consecutive ones:"+result);
	 }
}
