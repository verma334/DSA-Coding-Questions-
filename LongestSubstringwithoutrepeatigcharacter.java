package ArrayAndStringsDSAQuestions;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringwithoutrepeatigcharacter {

	public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l =0,r=0,max=0;

        while(r<s.length()){
            if(!set.contains(s.charAt(r))){
                set.add(s.charAt(r));
                max= Math.max(max,set.size());
                r++;
            }else{
                set.remove(s.charAt(l));
                l++;
            }
        }
        return max;

    }
	
	
	public static void main(String[] args) {
		LongestSubstringwithoutrepeatigcharacter ls = new LongestSubstringwithoutrepeatigcharacter();
		String s = "abcabcbb";
		int result = ls.lengthOfLongestSubstring(s);
		System.out.println("longest substring:"+result);
		
	}
}
