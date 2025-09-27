package ArrayAndStringsDSAQuestions;

public class ReverseString {


	public void reverseString(char[] s) {
        
        int start =0;
        int end = s.length - 1;
        while(start < end){
           char ch = s[start];
           s[start] = s[end];
           s[end] = ch;
           start++;
           end--;

        }
   }
	
	public static void main(String args[]) {
		ReverseString rs = new ReverseString();
		char[] s = {'h', 'e', 'l', 'l', 'o'}; // Use char[] instead of String[]
        rs.reverseString(s); // No need to assign result
        System.out.print("Reversed string: ");
        System.out.println(s); 
	}

}
