package ArrayAndStringsDSAQuestions;

public class Candy {

	public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        
        // Step 1: Give each child at least one candy
        for (int i = 0; i < n; i++) {
            candies[i] = 1;
        }
        
        // Step 2: Left to right pass
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Step 3: Right to left pass
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        // Step 4: Sum up all candies
        int total = 0;
        for (int c : candies) {
            total += c;
        }
        
        return total;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Candy c = new Candy();
		int[] ratings = {1,0,2};
				
		int result = c.candy(ratings);
		System.out.println("candy has:"+result);
		
	}

}
