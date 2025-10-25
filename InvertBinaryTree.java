package ArrayAndStringsDSAQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {


	public TreeNode invertTree(TreeNode root) {
        if(root == null){
          return null;  
        }

       Queue<TreeNode> queue = new LinkedList<>();
       queue.offer(root);
       while(!queue.isEmpty()){
        TreeNode node = queue.poll();
        TreeNode left = node.left;
         node.left = node.right;
         node.right=left;

         if(node.left != null){
            queue.offer(node.left);
         }
         if(node.right != null){
            queue.offer(node.right);
         }
       }
       return root;
	}
	
	public static void preorder(TreeNode root) {
        if (root == null) return;
       System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	        // Construct the binary tree
	        TreeNode root = new TreeNode(4);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(7);
	        root.left.left = new TreeNode(1);
	        root.left.right = new TreeNode(3);
	        root.right.left = new TreeNode(6);
	        root.right.right = new TreeNode(9);

	        InvertBinaryTree solution = new InvertBinaryTree();
	        TreeNode invertedRoot = solution.invertTree(root);

	        System.out.print("Preorder Traversal of Inverted Tree: ");
	        preorder(invertedRoot); // Output: 4 7 9 6 2 3 1
	    
	    }
	

}
