package ArrayAndStringsDSAQuestions;

import ArrayAndStringsDSAQuestions.CountGoodNodesInBinaryTree.TreeNode;

public class LowestCommonAncestorOfbinaryTree {

	
	public static class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode() {}
	     TreeNode(int val) { this.val = val; }
	      TreeNode(int val, TreeNode left, TreeNode right) {
	          this.val = val;
	          this.left = left;
	          this.right = right;
	      }
	  }
	 public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        if(root == null || root == p || root == q){
	            return root;
	        }

	        if(p.val<root.val && q.val<root.val){
	        return lowestCommonAncestor(root.left,p,q);
	        }


	        if(p.val>root.val && q.val>root.val){
	        return lowestCommonAncestor(root.right,p,q);
	        }

	        return root;
	 }
	 
	 public static void main(String[] args) {
		 LowestCommonAncestorOfbinaryTree lc = new LowestCommonAncestorOfbinaryTree();
		///// int[] root = {6,2,8,0,4,7,9,null,null,3,5};
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.left.right.left = new TreeNode(3);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);
		
		TreeNode p = root.left;       // Node with value 2
	    TreeNode q = root.right;      // Node with value 8
		  
		TreeNode result = lc.lowestCommonAncestor(root,p,q);
		System.out.println("lowest commom ancestor:"+result.val);
	 }
}
