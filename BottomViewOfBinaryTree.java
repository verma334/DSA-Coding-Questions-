package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

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
	 
	public static class Pair {
	    TreeNode node;
	    int hd;

	    Pair(TreeNode node, int hd) {
	        this.node = node;
	        this.hd = hd;
	    }
	}

	
	    public ArrayList<Integer> bottomView(TreeNode root) {
	        ArrayList<Integer> result = new ArrayList<>();
	        if (root == null) return result;

	        Map<Integer, Integer> map = new TreeMap<>();
	        Queue<Pair> queue = new LinkedList<>();

	        queue.offer(new Pair(root, 0));

	        while (!queue.isEmpty()) {
	            Pair curr = queue.poll();
	            TreeNode node = curr.node;
	            int hd = curr.hd;

	            map.put(hd, node.data);

	            if (node.left != null) queue.offer(new Pair(node.left, hd - 1));
	            if (node.right != null) queue.offer(new Pair(node.right, hd + 1));
	        }

	        for (int val : map.values()) {
	            result.add(val);
	        }

	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	          	BottomViewOfBinaryTree bt = new BottomViewOfBinaryTree();
				TreeNode root = new TreeNode(1);
		        root.left = new TreeNode(2);
		        root.right = new TreeNode(3);
		        root.left.left = new TreeNode(4);
		        root.left.right = new TreeNode(5);
		        root.right.right = new TreeNode(6);
		        
		        ArrayList<Integer> result =bt.bottomView(root);
				System.out.println("count complete nodes:"+result);
	}

}