package ArrayAndStringsDSAQuestions;

public class MinimumLinitofballsinbag {

	public int minimumSize(int[] nums, int maxOperations) {
        int left = 1;
        int right = getMax(nums);

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (canDivide(nums, maxOperations, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    // Helper to find the maximum value in the array
    private int getMax(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        return max;
    }

    // Check if we can make all bags <= maxSize using at most maxOperations
    private boolean canDivide(int[] nums, int maxOperations, int maxSize) {
        int operations = 0;
        for (int num : nums) {
            operations += (num - 1) / maxSize;
        }
        return operations <= maxOperations;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub4
		MinimumLinitofballsinbag mn  = new MinimumLinitofballsinbag();
		int[] nums = {9};
		int maxOperations = 2;
		int result = mn.minimumSize(nums, maxOperations);
		System.out.println("added mim limit of ba;l in bag:"+result);
 
	}

}
