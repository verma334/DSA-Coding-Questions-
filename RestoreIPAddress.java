package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddress {

	public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<String> result) {
        if (path.size() == 4) {
            if (start == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        for (int len = 1; len <= 3; len++) {
            if (start + len > s.length()) break;
            String segment = s.substring(start, start + len);
            if (isValid(segment)) {
                path.add(segment);
                backtrack(s, start + len, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.startsWith("0")) return false;
        int value = Integer.parseInt(segment);
        return value >= 0 && value <= 255;
    }

    public static void main(String[] args) {
    	RestoreIPAddress solver = new RestoreIPAddress();
        System.out.println(solver.restoreIpAddresses("25525511135"));
        System.out.println(solver.restoreIpAddresses("0000"));
        System.out.println(solver.restoreIpAddresses("101023"));
    }
}
