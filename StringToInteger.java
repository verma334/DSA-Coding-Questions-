package ArrayAndStringsDSAQuestions;

public class StringToInteger {
	public int myAtoi(String s) {
        int i =0;
        s = s.trim();
        int sign = 1;
        int n = s.length();
        long num =0;
        if(s.isEmpty()){
            return 0;
        }

        if(s.charAt(i) == '-' || s.charAt(i) == '+'){
            sign = (s.charAt(i) == '-')?-1:1;
            i++;
        }

        while(i<n && Character.isDigit(s.charAt(i)))
        {
         num = num*10 + (s.charAt(i) - '0');
         if(num*sign > Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
         }

         if(num*sign < Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
         }
             i++;
        }
           return (int) (sign*num);
    }
	
	
	public static void main(String args[]) {
		StringToInteger sc = new StringToInteger();
    	String s =  "words and 987";
		int result =sc.myAtoi(s);
		System.out.println("string to intefger:" + result);
	}
}
