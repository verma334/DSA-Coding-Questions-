package ArrayAndStringsDSAQuestions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WorkBreak {

	
	public boolean wordBreak(String s, List<String> wordDict) {
        // Convert wordDict to a HashSet for faster lookup
        Set<String> wordSet = new HashSet<>(wordDict);

        // Create a DP array where dp[i] means:
        // "Can the substring s[0...i-1] be segmented using words from wordDict?"
        boolean[] dp = new boolean[s.length() + 1];

        // Base case: empty string is always segmentable
        dp[0] = true;

        // Loop through each position in the string
        for (int i = 1; i <= s.length(); i++) {
            // Check all possible partitions ending at position i
            for (int j = 0; j < i; j++) {
                // If s[0...j-1] is segmentable and s[j...i-1] is a word in the dictionary
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    // Then s[0...i-1] is also segmentable
                    dp[i] = true;
                    break; // No need to check further partitions
                }
            }
        }

        // Return whether the entire string s[0...s.length()-1] is segmentable
        return dp[s.length()];
    }
	
	public static void main(String[] args) {
		    WorkBreak wb = new WorkBreak();
		    String s = "leetcode";
		    List<String> wordList = Arrays.asList("leet", "code"); // Convert array to List
		    boolean result = wb.wordBreak(s, wordList);            // Call method correctly
		    System.out.println(result); 
	}
}
