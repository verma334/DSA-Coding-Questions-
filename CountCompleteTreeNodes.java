package ArrayAndStringsDSAQuestions;

public class CountCompleteTreeNodes {

	
	public static int countNodes(TreeNode root) {
        int leftDepth = leftDepth(root);
        int rightDepth = rightDepth(root);
        if(leftDepth == rightDepth){
         return (int) Math.pow(2,leftDepth) - 1;
        }else{
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }
        private static int rightDepth(TreeNode root){
            int dep = 0;
            while(root != null){
                root = root.right;
                dep++;
            }
            return dep;
        }
        
        private static int leftDepth(TreeNode root){
            int dep = 0;
            while(root != null){
                root = root.left;
                dep++;
            }
            return dep;
        }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountCompleteTreeNodes ct = new CountCompleteTreeNodes();
		//int[] root = {1,2,3,4,5,6};
		TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        
		int result =ct.countNodes(root);
		System.out.println("count complete nodes:"+result);
	}

}
