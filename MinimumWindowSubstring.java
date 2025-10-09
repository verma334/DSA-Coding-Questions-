package ArrayAndStringsDSAQuestions;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

	public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";

        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int required = need.size();
        int formed = 0;
        Map<Character, Integer> window = new HashMap<>();

        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).intValue() == need.get(c).intValue()) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char d = s.charAt(left);
                window.put(d, window.get(d) - 1);
                if (need.containsKey(d) && window.get(d).intValue() < need.get(d).intValue()) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
	public static void main(String[] args) {
		MinimumWindowSubstring mw = new MinimumWindowSubstring();
		String s = "ADOBECODEBANC";
		String t = "ABC";
         String result=  mw.minWindow(s,t);
         System.out.println("minimum window substring:"+result);
	}
}
