package ArrayAndStringsDSAQuestions;

public class MaximumPointObtrainFromCards {
	 public int maxScore(int[] cardPoints, int k) {
	        int sum =0;
	        for(int i : cardPoints){
	            sum = sum + i;
	        }
	        int ans =0, window =0;
	        int n = cardPoints.length;


	        if(n==k){
	            return sum;
	        }

	        for(int i=0;i<n-k-1;i++){
	            window = window + cardPoints[i];
	        }

	        for(int i = n-k-1;i<n;i++){
	            window = window + cardPoints[i];
	            ans = Math.max(ans,sum-window);
	            window = window - cardPoints[i-(n-k-1)];
	        }
	        return ans;
	    }
	 
	 
	 
	 public static void main(String[] args) {
		 MaximumPointObtrainFromCards mp = new MaximumPointObtrainFromCards();
		 int[] cardPoints = {1,2,3,4,5,6,1};
		 int k = 3;
		 int result = mp.maxScore(cardPoints,k);
		 System.out.println("Maximum point obtsin from card:"+result);
	 }
}
