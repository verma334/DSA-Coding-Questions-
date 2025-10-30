package ArrayAndStringsDSAQuestions;

public class NoofGoodLeafNodePair {


    int count = 0;

  public int countPairs(TreeNode root, int distance) {
      dfs(root, distance);
      return count;
  }

  // Helper function that returns an array of distances from current node to leaf nodes
  private int[] dfs(TreeNode node, int distance) {
     if (node == null) return new int[distance + 1];

      // If it's a leaf node, return distance 1
      if (node.left == null && node.right == null) {
          int[] leafDist = new int[distance + 1];
          leafDist[1] = 1;
          return leafDist;
      }

      // Recursively get distances from left and right subtrees
      int[] left = dfs(node.left, distance);
      int[] right = dfs(node.right, distance);

      // Count valid leaf pairs between left and right subtrees
      for (int i = 1; i <= distance; i++) {
  for (int j = 1; j <= distance; j++) {
      if (i < left.length && j < right.length && i + j <= distance) {
          count += left[i] * right[j];
      }
  }
      }

      // Prepare distance array for parent node
      int[] current = new int[distance + 1];
      for (int i = 1; i < distance; i++) {
          current[i + 1] = left[i] + right[i];
      }

      return current;
  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
	        TreeNode root = new TreeNode(1);
	        root.left = new TreeNode(2);
	        root.right = new TreeNode(3);
	        root.left.right = new TreeNode(4);

	        int distance = 3;

	        NoofGoodLeafNodePair sol = new NoofGoodLeafNodePair();
	        int result = sol.countPairs(root, distance);
	        System.out.println("Number of good leaf node pairs: " + result); // Output: 1
	    }
	}


