package ArrayAndStringsDSAQuestions;

public class ReverseWordINString {

	public String reverseWords(String s) {
        if(s.equals(null) || s.equals("")){
            return s;
        }

        String res = "";
        int i = 0;
        while(i<s.length()){
            while(i<s.length() && s.charAt(i) == ' '){
                i++;
            }

         String w = "";
         while(i<s.length() && s.charAt(i) != ' '){
           w += s.charAt(i);
           i++;
        }

        if(!w.equals("")){
            res = w + " " + res;
        }
        
    }

    if(res.isEmpty()){
        return "";
    }

    return res.substring(0, res.length() - 1);
}
	
	public static void main(String args[]) {
		ReverseWordINString sc = new ReverseWordINString();
    	String s = "the sky is blue";
		String result =sc.reverseWords(s);
		System.out.println("Reverse strings are:" + result);
	}
}
