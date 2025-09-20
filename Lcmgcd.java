package MathQuestionsDSA;

public class Lcmgcd {

	 public static int[] lcmAndGcd(int a, int b) {
	        int gcd = findGCD(a, b);
	        int lcm = (a * b) / gcd;
	        return new int[]{lcm, gcd};
	    }

	    private static int findGCD(int a, int b) {
	        while (b != 0) {
	            int temp = b;
	            b = a % b;
	            a = temp;
	        }
	        return a;
	    }
	
}
