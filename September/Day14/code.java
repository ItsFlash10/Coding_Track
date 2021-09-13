package Day14;
import java.util.*;

// Find all pairs with a given sum
//https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x5808/0/?track=md-hashing&batchId=144#


class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}


class pairGivenSum{
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        
        HashSet<Long> map = new HashSet<>();
        
        for(int i = 0; i<N; i++)
        {
            map.add(A[i]);
        }
        
        Queue<pair> ans = new LinkedList<>();
        
        Arrays.sort(B);
        for(int i = 0; i<M; i++)
        {
            long target = X-B[i];
            if(map.contains(target))
            {
                pair P = new pair(target, B[i]);
                ans.add(P);
            }
        }
        pair[] res = new pair[(int)ans.size()];
        int j=ans.size()-1;
        while(ans.size()!=0)
        {
            res[j--] = ans.poll();
        }
        return res;
    }
}

// 3. Longest Substring Without Repeating Characters
//https://leetcode.com/problems/longest-substring-without-repeating-characters/

class longestSubString{
    public int lengthOfLongestSubstring(String s) {
        
        //O(N) using MAP -> BEST
        HashMap<Character,Integer> map = new HashMap<Character, Integer>();
        int res = 0;
        int left = 0;
        int right = 0;
        
        while(right<s.length())
        {
            if(map.containsKey(s.charAt(right)))
            {
                left = Math.max(map.get(s.charAt(right))+1, left);
            }
            map.put(s.charAt(right), right);
            
            res = Math.max(res, right-left+1);
            right++;
        }
        return res;

        // //O(2N) using SET
        // HashSet<Character> set = new HashSet<>();
        // int res = 0;
        // int left = 0;
        // int right = 0;
        
        // while(left < s.length() && right < s.length())
        // {
        //     if(!set.contains(s.charAt(right)))
        //     {
        //         set.add(s.charAt(right));
        //         right++;
        //         res = Math.max(res, set.size());
        //     }
        //     else
        //     {
        //         set.remove(s.charAt(left));
        //         left++;
        //     }
        // }
        // return res;        
    }
}