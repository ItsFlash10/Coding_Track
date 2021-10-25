package Day25;
import java.util.*;

//28. Implement strStr()
//https://leetcode.com/problems/implement-strstr/

class implStr {
    public int strStr(String haystack, String needle) {
        
        int nl = needle.length();
        int hl = haystack.length();        
        
        if (nl == 0)
            return 0;

        if (hl < nl)
            return -1;
        
        int pos = -1;    
        // match from end of needle
        for (int i = nl - 1; i < hl; i++) {
            pos = match(haystack, needle, i);
            if (pos != -1) 
                return pos;
        } 
        return -1;
    }
    
    int match(String haystack, String needle, int i) {        
        for (int j = needle.length() - 1; j >= 0; j--) {                        
            if (haystack.charAt(i) != needle.charAt(j))
                return -1;            
            i--;
        }
        return i + 1;
    }
}

//Implement strstr
//https://practice.geeksforgeeks.org/problems/implement-strstr/1/?track=md-string&batchId=144

class GfG
{
    //Function to locate the occurrence of the string x in the string s.
    int strstr(String s, String x)
    {
        int sl = s.length();
        int xl = x.length();
        
        if(xl == 0) return 0;
        if(xl > sl) return -1;
        
        for(int i = 0; i<=sl-xl; i++)
        {
            int j = 0;
            
            for(j  = 0; j<xl; j++)
            {
                if(s.charAt(i+j) != x.charAt(j))
                {
                    break;
                }
            }
            if(j == xl) return i;
        }
        return -1;
    }
}

//155. Min Stack
//https://leetcode.com/problems/min-stack/

class MinStack {
    Stack<int[] > stack;

    public MinStack() {
        
        stack = new Stack<>();        
    }
    
    public void push(int val) {
        if(stack.isEmpty())
        {
            stack.push(new int[] {val, val});
            return;
        }
        int currentMin = stack.peek()[1];
        
        stack.push(new int[] {val, Math.min(val, currentMin)});
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
