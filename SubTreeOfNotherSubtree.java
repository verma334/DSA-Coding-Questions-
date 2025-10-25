package ArrayAndStringsDSAQuestions;

import ArrayAndStringsDSAQuestions.ConvertSortedArrayToBinarySearchTree.TreeNode;

public class SubTreeOfNotherSubtree {
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int val) {
	        this.val = val;
	    }
	}

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
	     
		
        if (root == null) return false;

        // Check if trees match at current node or recurse left/right
        if (isSameTree(root, subRoot)) return true;

        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    // Helper method to check if two trees are identical
    private boolean isSameTree(TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;

        return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
    }
    
    public static void main(String[] args) {
    	
    	SubTreeOfNotherSubtree cs = new SubTreeOfNotherSubtree();

        // Manually building root tree
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        // Manually building subRoot tree
        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        boolean result = cs.isSubtree(root, subRoot);
        System.out.println("Is subRoot a subtree of root? " + result);
    }
    
}
