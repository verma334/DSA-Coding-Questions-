package ArrayAndStringsDSAQuestions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ImplementQueueUsingStack {

	Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public void MyQueue() {
        
    }
    
    public void push(int x) {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        stack1.push(x);
         while(!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
    
    public int pop() {
        return stack1.pop(); 
    }
    
    public int peek() {
       return stack1.peek();
    }
    
    public boolean empty() {
        return stack1.isEmpty();
    }
	
	
    public static void main(String[] args) {
        String[] commands = {"MyQueue", "push", "push", "peek", "pop", "empty"};
        int[][] values = {{}, {1}, {2}, {}, {}, {}};

        List<Object> output = new ArrayList<>();
        ImplementQueueUsingStack queue = null;

        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "MyQueue":
                    queue = new ImplementQueueUsingStack();
                    output.add(null);
                    break;
                case "push":
                    queue.push(values[i][0]);
                    output.add(null);
                    break;
                case "peek":
                    output.add(queue.peek());
                    break;
                case "pop":
                    output.add(queue.pop());
                    break;
                case "empty":
                    output.add(queue.empty());
                    break;
            }
        }

        System.out.println(output); // Output: [null, null, null, 1, 1, false]
    

}
}
