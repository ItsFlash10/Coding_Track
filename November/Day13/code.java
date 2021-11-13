package Day13;
import java.util.*;

//739. Daily Temperatures
//https://leetcode.com/problems/daily-temperatures/

class classicStack {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int[] answer = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<temperatures.length; i++)
        {
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()])
            {
                int index = st.pop();
                answer[index] = i-index;
            }
            st.add(i);
        }
        
        return answer;
    }
}

//Aditya Verma Way xD
class AVWay {
    public int[] dailyTemperatures(int[] temperatures) {
        
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int[] ans = new int[n];
        
        for(int i = n - 1; i >= 0; i--) 
        {
            while(!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) 
            {
                st.pop();
            }

            if(!st.isEmpty()) 
            {
                ans[i] = st.peek() - i;
            }
            st.push(i);
        }
        
        return ans;
    }
}
