package Day22;
import java.util.*;

//Remove Duplicates
//https://practice.geeksforgeeks.org/problems/remove-duplicates3034/1/?track=md-string&batchId=144

class Solution {
    String removeDups(String S) {
        
        HashSet<Character> set = new HashSet<>();
        String res = "";
        
        for(int i = 0; i<S.length(); i++)
        {
            char ch = S.charAt(i);
            
            if(!set.contains(ch))
            {
                set.add(ch);
                res += ch;
            }
        }
        return res;
    }
}