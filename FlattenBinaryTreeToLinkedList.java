package ArrayAndStringsDSAQuestions;

import java.util.Stack;

public class FlattenBinaryTreeToLinkedList {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    public static void flatten(TreeNode root) {
        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();

            if (curr.right != null) stack.push(curr.right);
            if (curr.left != null) stack.push(curr.left);

            curr.left = null;
            if (!stack.isEmpty()) curr.right = stack.peek();
        }
    }

    public static void printFlattenedTree(TreeNode root) {
        while (root != null) {
            System.out.print(root.data + " -> ");
            root = root.right;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        flatten(root);
        System.out.println("Flattened binary tree:");
        printFlattenedTree(root);
    }
}
