package ArrayAndStringsDSAQuestions;



public class ConvertSortedArrayToBinarySearchTree {


	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int val) {
	        this.val = val;
	    }
	}
	public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        
        return getBST(nums,0,nums.length -1);
    }

    public TreeNode getBST(int[] nums,int start,int end){
        if(start > end)
        return null;

        int middle = (start + end + 1) / 2;
        TreeNode bst = new TreeNode(nums[middle]);
        bst.left = getBST(nums,start,middle - 1);
        bst.right = getBST(nums,middle+1,end);
         return bst;

    }
     
    public static void main(String[] args) {
    	ConvertSortedArrayToBinarySearchTree cs = new ConvertSortedArrayToBinarySearchTree();
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode result = cs.sortedArrayToBST(nums);

        // Simple confirmation
        System.out.println("Root value: " + result.val); // Should be 0
        System.out.println("Left child: " + result.left.val); // Should be -3
        System.out.println("Right child: " + result.right.val); // Should be 9
        System.out.println("Left-left: " + result.left.left.val); // Should be -10
        System.out.println("Right-left: " + result.right.left.val); // Should be 5
    }
}

