package ArrayAndStringsDSAQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyStack {

	
	 private Queue<Integer> queue;
	    public MyStack() {
	      queue = new LinkedList<>();
	    }
	    
	    public void push(int x) {
	        queue.add(x);
	        for(int i=1;i<queue.size();i++){
	            queue.add(queue.remove());
	        }
	    }
	    
	    public int pop() {
	        return queue.remove();
	    }
	    
	    public int top() {
	        return queue.peek();
	    }
	    
	    public boolean empty() {
	        return queue.isEmpty();
	    }
	    public static void main(String[] args) {
	        MyStack stack = new MyStack();         // ["MyStack"]
	        stack.push(1);                         // ["push", [1]]
	        stack.push(2);                         // ["push", [2]]
	        System.out.println(stack.top());       // ["top"] → 2
	        System.out.println(stack.pop());       // ["pop"] → 2
	        System.out.println(stack.empty());     // ["empty"] → false
	    }
}
