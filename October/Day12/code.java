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

//567. Permutation in String
//https://leetcode.com/problems/permutation-in-string/

class stringPermutation{
    public boolean checkInclusion(String s1, String s2) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s1.length(); i++)
        {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0)+1);
        }
        
        int i = 0;
        int j = 0;
        int k = s1.length();
        int count = map.size();
        
        while(j < s2.length())
        {
            char ch = s2.charAt(j);
            
            if(map.containsKey(ch))
            {
                map.put(ch,map.getOrDefault(ch,0)-1);
                
                if(map.get(ch) == 0)
                {
                    count--;
                }
            }
            if(j-i+1 == k)
            {
                if(count == 0)
                {
                    return true;
                }
                
                if(map.containsKey(s2.charAt(i)))
                {
                    map.put(s2.charAt(i) , map.get(s2.charAt(i))+1);
                    
                    if(map.get(s2.charAt(i)) == 1) count ++;
                }
                i++;
            }
            j++;
        }
        return false;  
    }
}
