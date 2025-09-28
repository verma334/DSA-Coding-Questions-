package ArrayAndStringsDSAQuestions;

public class PrintNto1withoutloop {

	
	public void printNos(int N) {
        // Base case
        if (N == 0) {
            return;
        }

        // Print current number
        System.out.print(N + " ");

        // Recursive call with N-1
        printNos(N - 1);
    }
	
	public static void main(String args[]) {
		PrintNto1withoutloop ps = new PrintNto1withoutloop();
		int N = 10;
		System.out.println("Print n to 12 without loop:");
		ps.printNos(N);
		
		
	}
}
