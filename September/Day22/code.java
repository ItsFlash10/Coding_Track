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

//Remove duplicate elements from sorted Array
//https://practice.geeksforgeeks.org/problems/remove-duplicate-elements-from-sorted-array/1#

class remDup{
    int remove_duplicate(int A[],int N){
    
        int index = 1;
        for(int i =0;i<N-1;i++){
           if(A[i]!=A[i+1])
            A[index++] = A[i+1];
       }
       return index;
   }
}

//Smallest window in a string containing all the characters of another string 
//https://practice.geeksforgeeks.org/problems/smallest-window-in-a-string-containing-all-the-characters-of-another-string-1587115621/1/?track=md-hashing&batchId=144#

class adityaOP
{
    public static String smallestWindow(String s, String p)
    {
        //creating freq map for pattern string p 
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<p.length(); i++)
        {
            char temp = p.charAt(i);
            map.put(temp, map.getOrDefault(temp,0)+1);
        }
        
        int i = 0;
        int j = 0;
        int count = map.size();
        int min = Integer.MAX_VALUE;
        int start = -1;
        int end = -1;
        
        //traversing the main string s
        while(j < s.length())
        {
            char temp = s.charAt(j);
            if(map.containsKey(temp))
            {
                //diff here from other such ques is that we wont remove the K V pair
                //as -ve value hold significance that we can trim the substring further till freq is < 1
                map.put(temp, map.getOrDefault(temp,0)-1);
                if(map.get(temp) == 0)
                {
                    count--;
                }
            }
            
            if(count == 0)
            {
                //while count is 0 we can check the first idx and work for the same 
                //will increment count if its become 1 at any stage
                while(count == 0)
                {
                    char ch = s.charAt(i);
                    if(map.containsKey(ch))
                    {
                        map.put(ch, map.getOrDefault(ch,0)+1);
                        if(map.get(ch) == 1)
                        {
                            count++;
                        }
                    }

                    //min len of the substring will be calculated in each step//
                    if(min > j-i+1)
                    {
                        min = j-i+1;
                        start = i;
                        end = j+1;
                    }
                    i++;
                }
            }
            j++;
        }
        
        //return -1 of there's no substring
        return (start == -1 || end == -1) ? "-1" : s.substring(start, end); 
    }
}