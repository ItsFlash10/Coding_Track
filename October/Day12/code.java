package Day12;
import java.util.*;

//557. Reverse Words in a String III
//https://leetcode.com/problems/reverse-words-in-a-string-iii/

class revWrdsInString{
    public String reverseWords(String s) {
        
        char[] temp = s.toCharArray(); 
        
        int start = 0;
        int end = 0;
        
        while(end < temp.length)
        {
            while(end < temp.length && temp[end] != ' ')
            {
                end++;
            }
            reverse(temp, start, end-1);
            start = end+1;
            end++;
        }
        return new String(temp);
    }
    void reverse(char[] temp, int s, int e)
    {
        while(s<e)
        {
            char left = temp[s];
            temp[s] = temp[e];
            temp[e] = left;
            
            s++;
            e--;
        }
    }
}
