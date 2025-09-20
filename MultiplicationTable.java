package MathQuestionsDSA;

import java.util.ArrayList;

public class MultiplicationTable {

	
	static ArrayList<Integer> getTable(int n) {
		 ArrayList<Integer> table = new ArrayList<>();

		        for (int i = 1; i <= 10; i++) {
		            table.add(n * i);
		        }

		        return table;
		    }

		    public static void main(String[] args) {
		        int n = 9;
		        ArrayList<Integer> result = getTable(n);

		        for (int value : result) {
		            System.out.print(value + " ");
		        }
		    }
}
