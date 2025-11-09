package ArrayAndStringsDSAQuestions;

public class JumpGame {

	public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            // Track the farthest index reachable from current position
            farthest = Math.max(farthest, i + nums[i]);

            // When we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JumpGame jg = new JumpGame();
		int[] nums = {2,3,1,1,4};
		int result = jg.jump(nums);
		System.out.println("Jump game 2:"+result);
		
	}

}
