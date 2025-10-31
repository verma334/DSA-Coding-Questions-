package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.List;

import ArrayAndStringsDSAQuestions.NarrayTreeOrderTraversal.TreeNode;

public class SumTree {

	
	  // Binary Tree Node definition
    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Main method to check if a tree is a Sum Tree
    boolean isSumTree(TreeNode root) {
        return checkSumTree(root) != -1;
    }

    // Helper method to check if subtree is a Sum Tree
    private int checkSumTree(TreeNode node) {
        if (node == null) return 0; // An empty tree is a Sum Tree
        if (node.left == null && node.right == null) return node.data; // Leaf node is a Sum Tree

        int leftSum = checkSumTree(node.left);
        int rightSum = checkSumTree(node.right);

        // If either subtree is not a Sum Tree
        if (leftSum == -1 || rightSum == -1) return -1;

        // Check current node value
        if (node.data == leftSum + rightSum) {
            return node.data + leftSum + rightSum; // Return total sum of subtree
        } else {
            return -1; // Not a Sum Tree
        }
    }

    // Sample test
    public static void main(String[] args) {
        SumTree st = new SumTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
       
        boolean result = st.isSumTree(root);
        System.out.println("Is the tree a Sum Tree? " + result);
    }

}
