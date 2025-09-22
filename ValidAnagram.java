package ArrayAndStringsDSAQuestions;

import java.util.Arrays;

public class ValidAnagram {


    public boolean isAnagram(String s, String t) {
     // If lengths differ, they can't be anagrams
     if (s.length() != t.length()) return false;

     // Convert strings to character arrays
     char[] sArray = s.toCharArray();
     char[] tArray = t.toCharArray();

     // Sort both arrays
     Arrays.sort(sArray);
     Arrays.sort(tArray);

     // Compare sorted arrays
     return Arrays.equals(sArray, tArray);
 }

 public static void main(String[] args) {
     ValidAnagram sol = new ValidAnagram();
     System.out.println(sol.isAnagram("anagram", "nagaram")); // true
     System.out.println(sol.isAnagram("rat", "car"));         // false
 }
}
