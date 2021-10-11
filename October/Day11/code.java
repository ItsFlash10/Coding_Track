package Day11;
import java.util.*;

//232. Implement Queue using Stacks
//https://leetcode.com/problems/implement-queue-using-stacks/

class MyQueue {
    
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
        
    }

    public void push(int x) {
        while(!s1.isEmpty())
        {
            s2.push(s1.pop());
        }
        
        s1.push(x);
        
        while(!s2.isEmpty())
        {
            s1.push(s2.pop());   
        }
    }

    public int pop() {
        return s1.pop();                
    }

    public int peek() {
        return s1.peek();        
    }

    public boolean empty() {
        if(s1.size() == 0)
        {
            return true;
        }
        return false;
    }
}