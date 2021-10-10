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

//201. Bitwise AND of Numbers Range
//https://leetcode.com/problems/bitwise-and-of-numbers-range/

class bitwise{
    public int rangeBitwiseAnd(int left, int right) {
        
        int i = 0;
        for(; i<32; i ++)
            if(left>>i == right >>i)
                break;
        return left>>i << i;
    }
}