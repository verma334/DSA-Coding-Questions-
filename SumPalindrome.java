package MathQuestionsDSA;

public class SumPalindrome {

    boolean isDigitSumPalindrome(int n) {
        int digitSum = 0;

        
        while (n > 0) {
            digitSum += n % 10;
            n /= 10;
        }

        
        return isPalindrome(digitSum);
    }

   
    boolean isPalindrome(int num) {
        int original = num;
        int reversed = 0;

        while (num > 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }

        return original == reversed;
    }

}
