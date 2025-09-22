package ArrayAndStringsDSAQuestions;

public class MinimunSwap {

	 public static int minSwaps(int[] arr, int k) {
	        int n = arr.length;
	        int count = 0;

	        // Count elements ≤ k
	        for (int num : arr) {
	            if (num <= k) count++;
	        }

	        // Count bad elements in first window
	        int bad = 0;
	        for (int i = 0; i < count; i++) {
	            if (arr[i] > k) bad++;
	        }

	        int minSwaps = bad;
	        for (int i = 1; i <= n - count; i++) {
	            if (arr[i - 1] > k) bad--;
	            if (arr[i + count - 1] > k) bad++;
	            minSwaps = Math.min(minSwaps, bad);
	        }

	        return minSwaps;
	    }

	    public static void main(String[] args) {
	        MinimunSwap ms = new MinimunSwap();
	        int[] a = {2, 1, 5, 6, 3};
	        int k = 3;
	        int ans = ms.minSwaps(a, k); // ✅ Corrected method name
	        System.out.println("Minimum swaps required: " + ans); // Output: 1
	    }
}
