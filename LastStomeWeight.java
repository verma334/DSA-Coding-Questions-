package ArrayAndStringsDSAQuestions;

import java.util.Comparator;
import java.util.PriorityQueue;

public class LastStomeWeight {

	
	public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new  PriorityQueue<Integer> (
            new Comparator<Integer> () {
                public int compare(Integer a,Integer b){
                    return b - a;
                }
            }
        );

        for(int i =0;i<stones.length;i++){
            pq.add(stones[i]);
        }

        while(pq.size() > 1){
            int stone1 = pq.poll();
            int stone2 = pq.poll();
            if(stone1 > stone2){
                pq.add(stone1-stone2);
            }
        }

        if(pq.isEmpty()){
            return 0;
        }

        return pq.poll();
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LastStomeWeight lw = new LastStomeWeight();
		int[] stones = {2,7,4,1,8,1};
		int result =lw.lastStoneWeight(stones);
		System.out.println("last stone weightg:" +result);
		
	}

}
