package ArrayAndStringsDSAQuestions;

import java.util.Arrays;

public class RearrangeArrayAlternate {

	public static void rearrange(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr); // Sort the array first

        int maxIdx = n - 1;
        int minIdx = 0;
        int maxElem = arr[n - 1] + 1; // Greater than any element

        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                arr[i] += (arr[maxIdx] % maxElem) * maxElem;
                maxIdx--;
            } else {
                arr[i] += (arr[minIdx] % maxElem) * maxElem;
                minIdx++;
            }
        }

        // Decode the values
        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] / maxElem;
        }
    }

    public static void main(String[] args) {
    	RearrangeArrayAlternate sn = new RearrangeArrayAlternate();
        int[] arr = {1, 2, 3, 4, 5, 6};
        sn.rearrange(arr);
        System.out.println(Arrays.toString(arr));
    }

}
