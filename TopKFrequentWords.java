package ArrayAndStringsDSAQuestions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords {

	 public List<String> topKFrequent(String[] words, int k) {
	        // Step 1: Count the frequency of each word
	        Map<String, Integer> freqMap = new HashMap<>();
	        for (String word : words) {
	            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
	        }

	        // Step 2: Use a min-heap to keep the top k frequent words
	        PriorityQueue<String> heap = new PriorityQueue<>((a, b) -> {
	            int freqCompare = freqMap.get(a) - freqMap.get(b);
	            if (freqCompare == 0) {
	                return b.compareTo(a); // reverse lexicographical order
	            }
	            return freqCompare;
	        });

	        // Step 3: Add words to the heap
	        for (String word : freqMap.keySet()) {
	            heap.offer(word);
	            if (heap.size() > k) {
	                heap.poll(); // remove the least frequent or lexicographically larger
	            }
	        }

	        // Step 4: Build the result list in reverse order
	        LinkedList<String> result = new LinkedList<>();
	        while (!heap.isEmpty()) {
	            result.addFirst(heap.poll());
	        }

	        return result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopKFrequentWords tf = new TopKFrequentWords();
	    String[] words = {"i","love","leetcode","i","love","coding"};
	    int k =2;
		List<String> result = tf.topKFrequent(words,k);
		System.out.println("added top k freq works:"+result);

	}

}
