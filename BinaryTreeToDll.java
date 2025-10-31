package ArrayAndStringsDSAQuestions;


import ArrayAndStringsDSAQuestions.LowestCommonAncestorOfbinaryTree.TreeNode;

public class BinaryTreeToDll {
	
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
	
	TreeNode prev = null;  // Tracks the previous node in DLL
    TreeNode head = null;  // Head of the resulting DLL

    TreeNode bToDLL(TreeNode root) {
        convertToDLL(root);
        return head;
    }

    void convertToDLL(TreeNode node) {
        if (node == null) return;

        // Inorder traversal: Left → Root → Right
        convertToDLL(node.left);

        if (prev == null) {
            head = node; // First node becomes head
        } else {
            prev.right = node; // Link previous node to current
            node.left = prev;  // Link current node back to previous
        }
        prev = node; // Move prev forward

        convertToDLL(node.right);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTreeToDll converter = new BinaryTreeToDll();

	        // Build tree: root = [1, 2, 3]
	        TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(3);
	        root.right = new TreeNode(2);

	        TreeNode dllHead = converter.bToDLL(root);
//	        System.out.println("Binary tree to Dll:"+dllHead.val);
	        System.out.print("DLL from left to right: ");
	        TreeNode curr = dllHead;
	        while (curr != null) {
	            System.out.print(curr.val + " ");
	            curr = curr.right;
	        }
	}

}
