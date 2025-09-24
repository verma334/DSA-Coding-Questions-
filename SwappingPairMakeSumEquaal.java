package ArrayAndStringsDSAQuestions;

import java.util.HashSet;

public class SwappingPairMakeSumEquaal {

	 public static boolean findSwapValues(int[] a, int[] b) {
	        int sumA = 0, sumB = 0;

	        for (int num : a) sumA += num;
	        for (int num : b) sumB += num;

	        int diff = sumA - sumB;

	        // If the difference is odd, no swap can equalize the sums
	        if (diff % 2 != 0) return false;

	        int target = diff / 2;

	        // Store all elements of array A in a set for quick lookup
	        HashSet<Integer> setA = new HashSet<>();
	        for (int num : a) setA.add(num);

	        // Check if there's a value in B such that (b + target) exists in A
	        for (int num : b) {
	            if (setA.contains(num + target)) {
	                return true;
	            }
	        }

	        return false;
	    }

	    public static void main(String[] args) {
	    	SwappingPairMakeSumEquaal sn = new SwappingPairMakeSumEquaal();
	        int[] a1 = {4, 1, 2, 1, 1, 2};
	        int[] b1 = {3, 6, 3, 3};
	        System.out.println(sn.findSwapValues(a1, b1)); // true

	        int[] a2 = {5, 7, 4, 6};
	        int[] b2 = {1, 2, 3, 8};
	        System.out.println(sn.findSwapValues(a2, b2)); // true

	        int[] a3 = {3, 3};
	        int[] b3 = {6, 5, 6, 6};
	        System.out.println(sn.findSwapValues(a3, b3)); // false
	    }
}
