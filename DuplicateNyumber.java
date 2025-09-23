package ArrayAndStringsDSAQuestions;

public class DuplicateNyumber {

public int findDuplicate(int[] nums) {
        
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        while(slow != fast);
          slow = nums[0];
        
       
        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return fast;
    }

public static void main(String[] args) {
	 int[] nums = {1,3,4,2,2};
	 DuplicateNyumber dn = new DuplicateNyumber();
	 int result = dn.findDuplicate(nums);
	 System.out.println("elements are :"+result);
}
}
