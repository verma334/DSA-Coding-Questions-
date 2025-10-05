package ArrayAndStringsDSAQuestions;

import java.util.HashMap;

public class TwoSum {

	public static boolean twoSum(int arr[], int target) {
        // code here
       
       HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];
            if (map.containsKey(complement)) {
                // Found a pair: arr[i] + arr[map.get(complement)] = target
                return true;
            }
            map.put(arr[i], i); // Store current value with its index
        }

        return false; // No pair found 
    }
    
    public static void main(String[] args) {
        int[] arr1 = {0, -1, 2, -3, 1};
        int target1 = -2;
        System.out.println(twoSum(arr1, target1)); // true

        int[] arr2 = {1, -2, 1, 0, 5};
        int target2 = 0;
        System.out.println(twoSum(arr2, target2)); // false

        int[] arr3 = {11};
        int target3 = 11;
        System.out.println(twoSum(arr3, target3)); // false
    }
}
