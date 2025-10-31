package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class NarrayTreeOrderTraversal {

    // Definition of N-ary Tree Node
    public static class TreeNode {
        int data;
        List<TreeNode> children;

        TreeNode(int data) {
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    // Level Order Traversal method
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                level.add(current.data); // ✅ fixed: use data instead of val

                for (TreeNode child : current.children) {
                    queue.offer(child);
                }
            }

            result.add(level);
        }

        return result;
    }

    // Main method to test the traversal
    public static void main(String[] args) {
        NarrayTreeOrderTraversal nt = new NarrayTreeOrderTraversal();

        TreeNode root = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node4 = new TreeNode(4);
        root.children.add(node3);
        root.children.add(node2);
        root.children.add(node4);

        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node3.children.add(node5);
        node3.children.add(node6);

        List<List<Integer>> result = nt.levelOrder(root);
        System.out.println("N-ary tree level order traversal: " + result);
    }
    
}


