package ArrayAndStringsDSAQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumSumBSTInbinarytree {

    public static class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
        }
    }

    private int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        dfs(root);
        return maxSum;
    }

    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        if (left[0] == 1 && right[0] == 1 && node.data > left[2] && node.data < right[1]) {
            int sum = left[3] + right[3] + node.data;
            maxSum = Math.max(maxSum, sum);
            int minVal = Math.min(node.data, left[1]);
            int maxVal = Math.max(node.data, right[2]);
            return new int[]{1, minVal, maxVal, sum};
        } else {
            return new int[]{0, 0, 0, 0};
        }
    }

    // Helper method to build tree from array
    public static TreeNode buildTree(Integer[] arr) {
        if (arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int i = 1;

        while (i < arr.length) {
            TreeNode current = queue.poll();
            if (i < arr.length && arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;
            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String[] args) {
        MaximumSumBSTInbinarytree ms = new MaximumSumBSTInbinarytree();

        // Input: [1,4,3,2,4,2,5,null,null,null,null,null,null,4,6]
        Integer[] input = {1, 4, 3, 2, 4, 2, 5, null, null, null, null, null, null, 4, 6};
        TreeNode root = buildTree(input);

        int result = ms.maxSumBST(root);
        System.out.println("Maximum Sum BST in Binary Tree: " + result);
    }
}
