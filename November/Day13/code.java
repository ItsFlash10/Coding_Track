package Day13;

//739. Daily Temperatures
//https://leetcode.com/problems/daily-temperatures/

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        int n = temperatures.length;
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];
        
        for(int i = n-1; i>=0; i--)
        {
            if(s.empty())
            {
                ans[i] = 0;
            }
            
            else if(!s.empty() && s.peek() > i)
            {
                ans[i] = s.peek();
            }
            else if(!s.empty() && s.peek() <= i)
            {
                while(!s.empty() && s.peek() <= i)
                {
                    s.pop();
                }
                if(s.empty())
                {
                    ans[i] = 0;
                }
                else
                {
                    ans[i] = s.peek();
                }
            }
            s.push(i);
        }
        
        return ans;   
    }
}
