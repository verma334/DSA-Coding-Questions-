package ArrayAndStringsDSAQuestions;

import ArrayAndStringsDSAQuestions.FindDFuplicatreTree.TreeNode;

public class MinDistanceBetweenNodes {
	
	public static class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
	        this.data = data;
	        left = null;
	        right = null;
	    }
	}
	
	TreeNode findLCA(TreeNode root, int a, int b) {
        if (root == null) return null;
        if (root.data == a || root.data == b) return root;

        TreeNode left = findLCA(root.left, a, b);
        TreeNode right = findLCA(root.right, a, b);

        if (left != null && right != null) return root;
        return (left != null) ? left : right;
    }

    // Function to find distance from root to a given node
    int findLevel(TreeNode root, int target, int level) {
        if (root == null) return -1;
        if (root.data == target) return level;

        int left = findLevel(root.left, target, level + 1);
        if (left != -1) return left;

        return findLevel(root.right, target, level + 1);
    }

    // Main function to find distance between two nodes
    int findDist(TreeNode root, int a, int b) {
        TreeNode lca = findLCA(root, a, b);
        int d1 = findLevel(lca, a, 0);
        int d2 = findLevel(lca, b, 0);
        return d1 + d2;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinDistanceBetweenNodes md = new MinDistanceBetweenNodes();
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        int a = 2;
        int b = 3;
        int result = md.findDist(root,a,b);
        System.out.println("MinDistance between the nodes:"+result);
	}

}
