package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.List.*;
public class CombinationsBackTracking {

	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(n ,k ,new ArrayList<>() , ans);
        return ans;
    }


    public void solve(int n,int k,List<Integer> curr,List<List<Integer>> ans){

      
        if(k==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
          if(n == 0){
            return;
        }

        //pick
        curr.add(n);
        solve(n-1,k-1,curr,ans);
        /// not pick
        curr.remove(curr.size() - 1);
        solve(n-1,k,curr,ans);
    }
    
    public static void main(String args[]) {
    	CombinationsBackTracking cb = new CombinationsBackTracking();
    	int n = 4;
        int k = 2;
      List<List<Integer>> result= cb.combine(n, k);
      System.out.println("Combinations by backtracking:");
      for (List<Integer> combination : result) {
          System.out.println(combination);
      }
       
        
    	
    }
}
