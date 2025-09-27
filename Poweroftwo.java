package ArrayAndStringsDSAQuestions;

public class Poweroftwo {

	public boolean isPowerOfTwo(int n) {

	       if(n==0) {
	        return false;
	    
	       }
	       while(n!=1){
	        if(n%2!=0){
	            return false;
	        }else{
	            n=n/2;
	        }
	       }
	       return true;
	    }
	
	public static void main(String args[]) {
		Poweroftwo pt = new Poweroftwo();
		 int n =3;
		 System.out.println(pt.isPowerOfTwo(n));
	}
}
