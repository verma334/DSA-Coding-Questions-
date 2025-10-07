package ArrayAndStringsDSAQuestions;

public class CharacterReplacement {

	public int characterReplacement(String s, int k) {
        int[] count = new int[26]; // Frequency of each character in the window
        int maxCount = 0;          // Max frequency of a single character in the window
        int left = 0;              // Left pointer of the sliding window
        int maxLength = 0;         // Result: longest valid window length

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            count[ch - 'A']++; // Update frequency of current character
            maxCount = Math.max(maxCount, count[ch - 'A']); // Update max frequency

            // If window size - maxCount > k, we need to shrink the window
            while ((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--; // Remove leftmost character
                left++; // Shrink window from the left
            }

            // Update maxLength with current valid window size
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
	public static void main(String[] args) {
		CharacterReplacement cr = new CharacterReplacement();
		String s = "ABAB";
		int k = 2;
		int abc = cr.characterReplacement(s,k);
		System.out.println("character replacement:"+abc);
	}
}
