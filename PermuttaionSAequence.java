package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;

public class PermuttaionSAequence {

	public String getPermutation(int n, int k) {
        StringBuilder ans = new StringBuilder();
        ArrayList<Integer> numbers = new ArrayList<>();
        int fact = 1;
        for(int i=1;i<=n;i++){
            fact *= i;
            numbers.add(i);
        }
        k--;

        for(int i=0;i<n;i++){
            fact = fact/(n-i);
            int index = k/fact;
            ans.append(numbers.remove(index));
            k= k-(index * fact);
        }
        return ans.toString();
    }
	
	public static void main(String args[]) {
		PermuttaionSAequence ps = new PermuttaionSAequence();
    	int n =3;
    	int k= 3;
		String result =ps.getPermutation(n,k);
		System.out.println("Permuttaion Sequence:" + result);
	}
}
