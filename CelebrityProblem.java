package ArrayAndStringsDSAQuestions;

public class CelebrityProblem {

	
	public int celebrity(int mat[][]) {
        int n = mat.length;
        int candidate = 0;

        // Step 1: Find the potential celebrity
        for (int i = 1; i < n; i++) {
            if (mat[candidate][i] == 1) {
                candidate = i;
            }
        }

        // Step 2: Verify the candidate
        for (int i = 0; i < n; i++) {
            if (i == candidate) continue;
            if (mat[candidate][i] == 1 || mat[i][candidate] == 0) {
                return -1;
            }
        }

        return candidate;
    }
	
	public static void main(String[] args) {
		CelebrityProblem cb = new CelebrityProblem();
		int[][] mat = new int[][] {
		    {1, 1, 0},
		    {0, 1, 0},
		    {0, 1, 1}
		};
		int result =cb.celebrity(mat);
		System.out.println("celebroty p:"+result);

	}

}
