package ArrayAndStringsDSAQuestions;

public class LongestPalindrome {

	public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";

        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Expand around single character (odd length)
            int len1 = expandFromCenter(s, i, i);
            // Expand around pair of characters (even length)
            int len2 = expandFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);

          
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // Helper method to expand around center
    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1; // Length of palindrome
    }
    
    public static void main(String args[]) {
    	LongestPalindrome lp = new LongestPalindrome();
   	    String s =  "cbbd";
		String result =lp.longestPalindrome(s);
		System.out.println("LongestPalindrome:" + result);
	}
}
