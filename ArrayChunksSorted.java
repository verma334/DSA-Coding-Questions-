package ArrayAndStringsDSAQuestions;

public class ArrayChunksSorted {

public int maxChunksToSorted(int[] arr) {
        
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        int chunks = 0;

        for(int i =0;i<n;i++){
           max= Math.max(max,arr[i]);
           if(max < i+1){
            chunks++;
           }
        }

        return chunks;
    }

public static void main(String[] args) {
	ArrayChunksSorted ac = new ArrayChunksSorted();
	int[] arr = {4,3,2,1,0};
	int result = ac.maxChunksToSorted(arr);
	System.out.println("After sorting chunks:" +result);
}
}
