package ArrayAndStringsDSAQuestions;

import java.util.Collections;
import java.util.PriorityQueue;

public class Findmedian {

    // Max-heap for the smaller half
    private PriorityQueue<Integer> left;
    // Min-heap for the larger half
    private PriorityQueue<Integer> right;

    // Proper constructor (no return type!)
    public Findmedian() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        // Step 1: Add to max-heap first
        left.offer(num);

        // Step 2: Balance by moving largest from left to right
        right.offer(left.poll());

        // Step 3: Ensure left has equal or one more element than right
        if (left.size() < right.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {
        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        } else {
            return left.peek();
        }
    }

    public static void main(String[] args) {
        Findmedian fm = new Findmedian();

        fm.addNum(1); // arr = [1]
        fm.addNum(2); // arr = [1, 2]
        System.out.println(fm.findMedian()); // Output: 1.5

        fm.addNum(3); // arr = [1, 2, 3]
        System.out.println(fm.findMedian()); // Output: 2.0
    }
}
