package ArrayAndStringsDSAQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class TimeNeededToBuyTickes {

	public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0;i<tickets.length;i++){
            queue.add(i);
        }
        int seconds = 0;
        while(!queue.isEmpty()){
            seconds++;
            int person = queue.poll();
            if(tickets[person] >= 1){
                tickets[person]--;
            }
            if(person == k && tickets[person] == 0){
               break;
            }
            if(person != k && tickets[person] == 0){
               continue;
            }
            queue.add(person);

        }
        return seconds;
    }
	
	public static void main(String[] args) {
		TimeNeededToBuyTickes tn = new TimeNeededToBuyTickes();
		int[] tickets = {2,3,2};
		int k = 2;
		int result = tn.timeRequiredToBuy(tickets,k);
		System.out.println("tockets to but:"+result);
	}
}
