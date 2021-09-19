import java.util.*;

//Longest K unique characters substring 
//https://practice.geeksforgeeks.org/problems/longest-k-unique-characters-substring0853/1#

class Solution {
    public int longestkSubstr(String s, int k) {
        
        int i = 0;
        int j = 0;
        int res = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        
        while(j<s.length())
        {
            char ch = s.charAt(j);
            map.put(ch, map.getOrDefault(ch, 0)+1);
            
            if(map.size() < k) j++;
            
            else if(map.size() == k)
            {
                res = Math.max(res, j-i+1);
                j++;
            }
            
            else if(map.size() > k)
            {
                while(map.size() > k)
                {
                    char rel = s.charAt(i);
                    map.put(rel, map.getOrDefault(rel, 0) - 1);
                    if(map.get(rel) == 0)
                    {
                        map.remove(rel);
                    }
                    i++;
                }
                j++;
            }
        }
        return res;
    }
}
