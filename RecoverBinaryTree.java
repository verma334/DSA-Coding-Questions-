package ArrayAndStringsDSAQuestions;

import java.util.*;

public class RecoverBinaryTree {

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

    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode prev = new TreeNode(Integer.MIN_VALUE);

    public void recoverTree(TreeNode root) {
        inorder(root);

        // Swap the values of the two incorrect nodes
        if (first != null && second != null) {
            int temp = first.data;
            first.data = second.data;
            second.data = temp;
        }
    }

    private void inorder(TreeNode root) {
        if (root == null) return;

        inorder(root.left);

        // Detect swapped nodes
        if (prev.data > root.data) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }

        prev = root;

        inorder(root.right);
    }

    // Helper method to print in-order traversal
    public void printInOrder(TreeNode root) {
        if (root == null) return;
        printInOrder(root.left);
        System.out.print(root.data + " ");
        printInOrder(root.right);
    }

    // Helper method to print level-order traversal as array format
    public void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        List<String> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr != null) {
                result.add(String.valueOf(curr.data));
                queue.offer(curr.left);
                queue.offer(curr.right);
            } else {
                result.add("null");
            }
        }

        // Remove trailing "null"s
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            result.remove(i);
            i--;
        }

        System.out.println(result);
    }

    public static void main(String[] args) {
        RecoverBinaryTree rb = new RecoverBinaryTree();

        // Constructing the tree: [1,3,null,null,2]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.left.right = new TreeNode(2);

        System.out.println("Before recovery (in-order):");
        rb.printInOrder(root); // Output should be incorrect

        System.out.println("\nBefore recovery (level-order):");
        rb.printLevelOrder(root); // Output as array

        rb.recoverTree(root);

        System.out.println("\nAfter recovery (in-order):");
        rb.printInOrder(root); // Output should be sorted

        System.out.println("\nAfter recovery (level-order):");
        rb.printLevelOrder(root); // Output as array
    }
}
