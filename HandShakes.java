package ArrayAndStringsDSAQuestions;

public class HandShakes {

	static int count(int N) {
        // code here
        
        if(N % 2 != 0){
            return 0;
        }
        int n = N/2;
        int[] catalan = new int[n+1];
        catalan[0] = 1;
        
        
        
        for(int i = 1;i<=n;i++){
           catalan[i]  = 0;
           for(int j=0;j<i;j++){
               catalan[i] += catalan[j] * catalan[i-j-1];
           }
        }
        
        return catalan[n];
    }
    
    
    public static void main(String[] args){
        int[] testCases = {2,4,6,8,10,12,14,16,18,20};
        for(int N : testCases){
            System.out.println("Input:" + N +"-> Output:" +count(N));
        }
        
    }
}
