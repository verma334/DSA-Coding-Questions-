package MathQuestionsDSA;

public class CountSquares {

	
	 public static int countSquares(int n) {
	        // Start from 1 and keep squaring until the square is >= n
	        int count = 0;
	        int i = 1;
	        while (i * i < n) {
	            count++;
	            i++;
	        }
	        return count;
	    }

	    public static void main(String[] args) {
	        int n1 = 9;
	        int n2 = 3;

	        System.out.println("Perfect squares less than " + n1 + ": " + countSquares(n1)); // Output: 2
	        System.out.println("Perfect squares less than " + n2 + ": " + countSquares(n2)); // Output: 1
	    }
}
