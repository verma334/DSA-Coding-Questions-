package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ArrayAndStringsDSAQuestions.RecoverBinaryTree.TreeNode;

public class VerticalOrderTraversalBinaryTree {
	
	public static class TreeNode {
	    int data;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int data) {
	        this.data = data;
	    }
	} 

	public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> nodeList = new ArrayList<>();
        dfs(root, 0, 0, nodeList);

        Collections.sort(nodeList, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]); // col
            if (a[0] != b[0]) return Integer.compare(a[0], b[0]); // row
            return Integer.compare(a[2], b[2]); // value
        });

        List<List<Integer>> result = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (int[] node : nodeList) {
            int row = node[0], col = node[1], val = node[2];
            if (col != prevCol) {
                result.add(new ArrayList<>());
                prevCol = col;
            }
            result.get(result.size() - 1).add(val);
        }

        return result;
    }

    private void dfs(TreeNode node, int row, int col, List<int[]> nodeList) {
        if (node == null) return;
        nodeList.add(new int[]{row, col, node.data});
        dfs(node.left, row + 1, col - 1, nodeList);
        dfs(node.right, row + 1, col + 1, nodeList);
    }
    public static void main(String[] args) {
        VerticalOrderTraversalBinaryTree tree = new VerticalOrderTraversalBinaryTree();

        // Constructing the tree: [3,9,20,null,null,15,7]
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = tree.verticalTraversal(root);

        System.out.println("Vertical Order Traversal:");
        for (List<Integer> col : result) {
            System.out.println(col);
        }
    }

}
