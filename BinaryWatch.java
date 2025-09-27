package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {
	public List<String> readBinaryWatch(int num) {
        ArrayList<String> results = new ArrayList<String>();
       
        for(int hour =0;hour<12;hour++){
            for(int minute=0;minute<60;minute++){
                if(Integer.bitCount(hour) + Integer.bitCount(minute) == num){
                    if(minute<10){
                        results.add(String.format("%d:0%d",hour,minute));
                    }else{
                        results.add(String.format("%d:%d",hour,minute));
                    }
                }
            }
        }

        return results;

    }
	
	public static void main(String args[]) {
		BinaryWatch bw = new BinaryWatch();
		 int n =1;
		 System.out.println(bw.readBinaryWatch(n));
	}

}

