package ArrayAndStringsDSAQuestions;

import java.util.HashMap;
import java.util.Map;

public class IsometricString {
		
public static boolean isIsomorphic(String s, String t) {
        
        if (s.length() != t.length()) {
            return false;
        }

        Map<Character, Character> charMappingMap = new HashMap<>();
        Map<Character, Character> reverseMappingMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char original = s.charAt(i);
            char replacement = t.charAt(i);

            // If original is already mapped, check consistency
            if (charMappingMap.containsKey(original)) {
                if (charMappingMap.get(original) != replacement) {
                    return false;
                }
            } else {
                // If replacement is already used for another character, return false
                if (reverseMappingMap.containsKey(replacement)) {
                    return false;
                }

                // Create new mapping
                charMappingMap.put(original, replacement);
                reverseMappingMap.put(replacement, original);
            }
        }

        return true;
	
}

public static void main(String[] args) {
	 System.out.println(isIsomorphic("egg", "add"));     // true

   
     System.out.println(isIsomorphic("foo", "bar"));     // false

    
     System.out.println(isIsomorphic("paper", "title")); // true
}
}
