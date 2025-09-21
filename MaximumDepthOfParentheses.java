package ArrayAndStringsDSAQuestions;

public class MaximumDepthOfParentheses {

	

    // Define the method maxDepth that takes a string and returns an integer
    public int maxDepth(String s) {

        // Variable to store the maximum depth found so far
        int maxDepth = 0;

        // Variable to track the current depth while scanning the string
        int currentDepth = 0;

        // Loop through each character in the string
        for (char c : s.toCharArray()) {

            // If the character is an opening parenthesis, increase current depth
            if (c == '(') {
                currentDepth++;

                // Update maxDepth if currentDepth is greater than maxDepth
                maxDepth = Math.max(maxDepth, currentDepth);
            }

            // If the character is a closing parenthesis, decrease current depth
            else if (c == ')') {
                currentDepth--;
            }
        }

        // After scanning the string, return the maximum depth found
        return maxDepth;
    }
    
    
 // Main method to run the program
    public static void main(String[] args) {

        // Create an object of the Solution class
    	MaximumDepthOfParentheses sol = new MaximumDepthOfParentheses();

        // Define a sample input string with nested parentheses
        String input = "(1+(2*3)+((8)/4))+1";

        // Call the maxDepth method and store the result
        int result = sol.maxDepth(input);

        // Print the result to the console
        System.out.println("Maximum Depth of Parentheses: " + result);
    }
}
