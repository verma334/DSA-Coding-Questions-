package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.List;


public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(candidates,target,0,new ArrayList<>(),res);
        return res;
    }



    private void backtrack(int[] c ,int target,int idx,List<Integer> path,List<List<Integer>> res){

     if(target == 0){
        res.add(new ArrayList<>(path));  ///stoire
        return;
     }

     if(target < 0){
        return;
     }

     for(int i = idx;i<c.length;i++){
        path.add(c[i]);
        backtrack(c,target-c[i],i,path,res);
        path.remove(path.size() - 1);
     }

    }
    
    public static void main(String[] args) {
    	CombinationSum cs = new CombinationSum();
    	int[]  candidates = {2,3,6,7};
    	int target = 7;
    	System.out.println("combination sum:");
    	List<List<Integer>> result = cs.combinationSum(candidates, target);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    
    }
}
