package Day5;
import java.util.*;

//387. First Unique Character in a String
//https://leetcode.com/problems/first-unique-character-in-a-string/

class idxOffirstUnique{
    public int firstUniqChar(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        for(int i = 0; i<s.length(); i++)
        {
            char ch = s.charAt(i);
            if(map.get(ch) == 1)
            {
                return i;
            } 
        }
        return -1;
    }
}

//242. Valid Anagram
//https://leetcode.com/problems/valid-anagram/

class validAnagram {
    public boolean isAnagram(String s, String t) {
        
        if(s.length() != t.length()) return false;
        
        int[] arr = new int[26];
        
        for(int i = 0; i < s.length(); i++)
        {
            arr[s.charAt(i) - 'a']++;
        }
        
        for(int i = 0; i < t.length(); i++)
        {
            arr[t.charAt(i) - 'a']--;
        }
        
        for(int i : arr)
        {
            if(i > 0) return false;
        }
        return true;  
    }
}