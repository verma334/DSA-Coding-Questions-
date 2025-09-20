package ArrayAndStringsDSAQuestions;

public class EquilibriumPoint {

	
	public static void main(String[] args){
        int[] arr = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(findEquilibrium(arr)); // Output: 3
    }

    public static int findEquilibrium(int[] arr) {
        int totalSum = 0;

        // Step 1: Calculate total sum of the array
        for (int num : arr) {
            totalSum += num;
        }

        int leftSum = 0;

        // Step 2: Traverse the array and check for equilibrium
        for (int i = 0; i < arr.length; i++) {
            int rightSum = totalSum - leftSum - arr[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1; // No equilibrium index found
    }
}
