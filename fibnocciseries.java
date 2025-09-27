package ArrayAndStringsDSAQuestions;

public class fibnocciseries {

	
	 public int fib(int n) {
	        if(n ==0)
	         return 0;

	         int first = 0;
	         int second =1;

	         while(n>1){
	            int temp = second;
	            second = second+first;
	            first = temp;
	            n--;
	         }

	       return second;
	        
	    }
	 
	 public static void main(String args[]) {
		     fibnocciseries fs = new fibnocciseries();
			 int n =2;
			 System.out.println(fs.fib(n));
		}
	 
	 
}
