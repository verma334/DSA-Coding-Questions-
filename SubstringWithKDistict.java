package ArrayAndStringsDSAQuestions;

import java.util.HashMap;
import java.util.Map;

public class SubstringWithKDistict {

	public int countSubstr(String s, int k) {
        return atMostK(s, k) - atMostK(s, k - 1);
    }

    private int atMostK(String s, int k) {
        int left = 0, right = 0, count = 0;
        Map<Character, Integer> freq = new HashMap<>();

        while (right < s.length()) {
            char ch = s.charAt(right);
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);

            // Shrink window if distinct characters exceed k
            while (freq.size() > k) {
                char leftChar = s.charAt(left);
                freq.put(leftChar, freq.get(leftChar) - 1);
                if (freq.get(leftChar) == 0) freq.remove(leftChar);
                left++;
            }

            // Add number of substrings ending at right
            count += right - left + 1;
            right++;
        }

        return count;
    }
    
    public static void main(String args[]) {
    	SubstringWithKDistict sc = new SubstringWithKDistict();
    	String s = "abc";
    	int k = 2;
		int result =sc.countSubstr(s,k);
		System.out.println("Possible substrings are:" + result);
	}
}
