package ArrayAndStringsDSAQuestions;
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
	
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int val) {
	        this.val = val;
	    }
	}
	
	    public List<String> binaryTreePaths(TreeNode root) {
	        List<String> result = new ArrayList<>();
	        if (root != null) {
	            dfs(root, "", result);
	        }
	        return result;
	    }

	    private void dfs(TreeNode node, String path, List<String> result) {
	        if (node.left == null && node.right == null) {
	            result.add(path + node.val); // Leaf node
	        }
	        if (node.left != null) {
	            dfs(node.left, path + node.val + "->", result);
	        }
	        if (node.right != null) {
	            dfs(node.right, path + node.val + "->", result);
	        }
	    }

	    // Optional: You can add a main method to test it
	    public static void main(String[] args) {
	        TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.right = new TreeNode(5);

	        BinaryTreePaths solution = new BinaryTreePaths();
	        List<String> paths = solution.binaryTreePaths(root);
	        System.out.println(paths); // Output: [1->2->5, 1->3]
	    }
	

}
