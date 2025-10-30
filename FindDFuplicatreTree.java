package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindDFuplicatreTree {
	public static class TreeNode {
	    int val;
	    TreeNode left;
	    TreeNode right;

	    TreeNode(int val) {
	        this.val = val;
	        left = null;
	        right = null;
	    }
	}
	 
	   List<TreeNode> res = new ArrayList<>();
	    HashMap<String,Integer> dic = new HashMap<>();

	    public String solve(TreeNode root){
	        if(root == null)
	        return "";
	        String val = root.val + "_" +solve(root.left) + "_" +solve(root.right);
	        dic.put(val,dic.getOrDefault(val,0) + 1);
	        if(dic.get(val) == 2)
	        res.add(root);
	        return val;
	    }

	    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
	        solve(root);
	        return res;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindDFuplicatreTree dc = new FindDFuplicatreTree();
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        root.right.left.left = new TreeNode(4);
        List<TreeNode> duplicates = dc.findDuplicateSubtrees(root);

        List<List<Integer>> output = new ArrayList<>();
        for (TreeNode node : duplicates) {
            output.add(levelOrder(node)); // levelOrder gives [2, 4] or [4]
        }

        System.out.println(output); // Output: [[2, 4], [4]]
		
        
	}

	public static List<Integer> levelOrder(TreeNode root) {
	    List<Integer> result = new ArrayList<>();
	    Queue<TreeNode> queue = new LinkedList<>();
	    queue.offer(root);

	    while (!queue.isEmpty()) {
	        TreeNode node = queue.poll();
	        result.add(node.val);
	        if (node.left != null) queue.offer(node.left);
	        if (node.right != null) queue.offer(node.right);
	    }

	    return result;
	}
}
