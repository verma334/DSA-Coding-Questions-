package ArrayAndStringsDSAQuestions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BurningTree {

	// Helper method to map each node to its parent
    private void mapParents(TreeNode root, Map<TreeNode, TreeNode> parentMap) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            if (curr.left != null) {
                parentMap.put(curr.left, curr);
                queue.offer(curr.left);
            }
            if (curr.right != null) {
                parentMap.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }

    // Helper method to find the target node
    private TreeNode findTarget(TreeNode root, int target) {
        if (root == null) return null;
        if (root.val == target) return root;
        TreeNode left = findTarget(root.left, target);
        if (left != null) return left;
        return findTarget(root.right, target);
    }

    public int minTime(TreeNode root, int target) {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        mapParents(root, parentMap);

        TreeNode targetNode = findTarget(root, target);
        if (targetNode == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        queue.offer(targetNode);
        visited.add(targetNode);

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean burned = false;

            for (int i = 0; i < size; i++) {
                TreeNode curr = queue.poll();

                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    queue.offer(curr.left);
                    burned = true;
                }

                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    queue.offer(curr.right);
                    burned = true;
                }

                TreeNode parent = parentMap.get(curr);
                if (parent != null && !visited.contains(parent)) {
                    visited.add(parent);
                    queue.offer(parent);
                    burned = true;
                }
            }

            if (burned) time++;
        }

        return time;
    }
    public static void main(String[] args) {
        // Build the binary tree: [1, 2, 3, 4, 5, 6, 7]
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        int target = 2;

        BurningTree bt = new BurningTree();
        int timeToBurn = bt.minTime(root, target);

        System.out.println("Minimum time to burn the tree from target " + target + " is: " + timeToBurn);
    }


}
