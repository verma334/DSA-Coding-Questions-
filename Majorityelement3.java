package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Majorityelement3 {

	public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }

        for(int num : map.keySet()){
            
            if(map.get(num) > (n/3)){
                list.add(num);
            }
         }
        return list;
    }
	
	public static void main(String[] args) {
		Majorityelement3 me = new Majorityelement3();
		int [] nums = {3,2,3};
		List<Integer> result = me.majorityElement(nums);
		System.out.println("After elements will be:" +result);
		
		
	}
}
