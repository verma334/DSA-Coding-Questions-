package MathQuestionsDSA;

public class AddDigits {

	public static void main(String args[]) {
        int num = 36;
        System.out.println(addDigits(num));
    }

    public static int addDigits(int num) {

        if (num == 0) {
            return 0;
        }

        return (num % 9 == 0) ? 9 : num % 9;
    }
}

