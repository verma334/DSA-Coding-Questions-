package ArrayAndStringsDSAQuestions;



public class CountGoodNodesInBinaryTree {

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
	
	public int goodNodes(TreeNode root) {
	       return helper(root,root.val);
	    }

	    public int helper(TreeNode node,int maxVal){
	        if(node == null)
	        return 0;
	        int count =0;
	        if(node.val >= maxVal){
	            count = 1;
	            maxVal = node.val;
	        }

	        count += helper(node.left,maxVal);
	        count += helper(node.right,maxVal);
	        return count;
	    }
	    
	public static void main(String[] args) {
		CountGoodNodesInBinaryTree cg = new CountGoodNodesInBinaryTree();
		
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.right = new TreeNode(4);
		root.left.left = new TreeNode(3);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(5);

		int result =cg.goodNodes(root);
		System.out.println("good nopdes present as a:"+result);
	}

}
