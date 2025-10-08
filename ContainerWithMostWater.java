package ArrayAndStringsDSAQuestions;

public class ContainerWithMostWater {

	 public int maxArea(int[] height) {
	       int left = 0;
	       int right = height.length -1 ;
	       int maxArea = 0;
	       int currentArea = 0;  
	       while(left < right){
	        currentArea= (int)(Math.min(height[left],height[right]) * (right-left));
	        maxArea = Math.max(currentArea,maxArea);
	        if(height[left] <= height[right]){
	            left++;
	        }else if(height[left] > height[right]){
	           right--;
	        }
	       }
	       return maxArea;
	    }
	 
	 public static void main(String[] args) {
		 ContainerWithMostWater cm = new ContainerWithMostWater();
		  int[]  height = {1,8,6,2,5,4,8,3,7};
		 int result =cm.maxArea(height);
		 System.out.println("contsiner with most warer:"+result);
	 }
}
