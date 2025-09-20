package MathQuestionsDSA;

public class ReversingEquation {

	 public static String reverseEqn(String S) {
	        StringBuilder result = new StringBuilder();
	        StringBuilder number = new StringBuilder();

	        // Traverse from end to start
	        for (int i = S.length() - 1; i >= 0; i--) {
	            char ch = S.charAt(i);

	            if (Character.isDigit(ch)) {
	                number.insert(0, ch); // build number in correct order
	            } else {
	                result.append(number); // add complete number
	                number.setLength(0);   // reset number
	                result.append(ch);     // add operator
	            }
	        }

	        // Add the last number
	        result.append(number);

	        return result.toString();
	    }

	    public static void main(String[] args) {
	        String S1 = "20-3+5*2";
	        String S2 = "5+2*56-2/4";

	        System.out.println(reverseEqn(S1)); // Output: 2*5+3-20
	        System.out.println(reverseEqn(S2)); // Output: 4/2-56*2+5
	    }
}
