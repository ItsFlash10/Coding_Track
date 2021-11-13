package Day13;

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
