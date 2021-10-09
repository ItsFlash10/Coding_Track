package Day10;
import java.util.*;

//20. Valid Parentheses
//https://leetcode.com/problems/valid-parentheses/submissions/

class validParth{
    public boolean isValid(String s) {
        
        Stack<Character> st = new Stack<>();
        
        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            
            if(ch == '{' || ch == '(' || ch == '[')
            {
                st.push(ch);
            }
            else if(st.isEmpty()) return false;
            
            else if(ch == ')' && st.pop() != '(') return false;
            
            else if(ch == '}' && st.pop() != '{') return false;
            
            else if(ch == ']' && st.pop() != '[') return false;
        }
        return st.empty();
    }
}
