package MathQuestionsDSA;

public class MultilplyTwoString {

	 public String multiplyStrings(String s1, String s2) {
	        // Check for negative signs
	        boolean isNegative = false;
	        if (s1.charAt(0) == '-') {
	            isNegative = !isNegative;
	            s1 = s1.substring(1);
	        }
	        if (s2.charAt(0) == '-') {
	            isNegative = !isNegative;
	            s2 = s2.substring(1);
	        }

	        // Remove leading zeros
	        s1 = removeLeadingZeros(s1);
	        s2 = removeLeadingZeros(s2);

	        // If either number is "0", the result is "0"
	        if (s1.equals("0") || s2.equals("0")) return "0";

	        int n = s1.length();
	        int m = s2.length();
	        int[] result = new int[n + m];

	        // Multiply each digit from the end (like manual multiplication)
	        for (int i = n - 1; i >= 0; i--) {
	            int digit1 = s1.charAt(i) - '0';
	            for (int j = m - 1; j >= 0; j--) {
	                int digit2 = s2.charAt(j) - '0';
	                int mul = digit1 * digit2;
	                int sum = mul + result[i + j + 1];

	                result[i + j + 1] = sum % 10; // store the unit place
	                result[i + j] += sum / 10;    // carry to the left
	            }
	        }

	        // Convert result array to string
	        StringBuilder sb = new StringBuilder();
	        int i = 0;

	        // Skip leading zeros
	        while (i < result.length && result[i] == 0) i++;

	        for (; i < result.length; i++) {
	            sb.append(result[i]);
	        }

	        // Add negative sign if needed
	        if (isNegative) {
	            sb.insert(0, '-');
	        }

	        return sb.toString();
	    }

	    // Helper method to remove leading zeros
	    private String removeLeadingZeros(String str) {
	        int i = 0;
	        while (i < str.length() - 1 && str.charAt(i) == '0') {
	            i++;
	        }
	        return str.substring(i);
	    }
}
