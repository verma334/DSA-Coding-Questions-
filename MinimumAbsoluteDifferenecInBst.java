package ArrayAndStringsDSAQuestions;

import java.util.*;


public class MinimumAbsoluteDifferenecInBst {

	int minDifference = Integer.MAX_VALUE;
    Integer prev = null;
    public int getMinimumDifference(TreeNode root) {
       if(root == null) {
        return minDifference;
       }

       getMinimumDifference(root.left);

       if(prev!= null){
        minDifference = Math.min(minDifference ,root.val-prev);
       }

       if(root !=null){
        prev = root.val;
       }

       getMinimumDifference(root.right);
       return minDifference;
    }
    public static void main(String[] args) {
        
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        MinimumAbsoluteDifferenecInBst solution = new MinimumAbsoluteDifferenecInBst();
        //int[] root = {4,2,6,1,3};
        int result = solution.getMinimumDifference(root);
        System.out.println("Minimum Absolute Difference: " + result);
    }
	
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}
