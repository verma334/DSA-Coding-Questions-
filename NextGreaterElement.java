package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreaterElement {
	public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            temp[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        // Convert int[] to ArrayList<Integer>
        ArrayList<Integer> result = new ArrayList<>(n);
        for (int val : temp) {
            result.add(val);
        }

        return result;
    }
	
	public static void main(String[] args) {
		NextGreaterElement ng = new NextGreaterElement();
		int[] arr = {1, 3, 2, 4};
		ArrayList<Integer> result =ng.nextLargerElement(arr);
		System.out.println("next hreatrer elemnt:"+result);
	}

}
