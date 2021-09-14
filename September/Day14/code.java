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

//56. Merge Intervals
//https://leetcode.com/problems/merge-intervals/

class mergeIntervals{
    public int[][] merge(int[][] intervals) {
        
        List<int[]> res = new ArrayList<>();
        
        if(intervals.length == 0 || intervals == null)
        {
            return res.toArray(new int[0][]);
        }
        
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        
        for(int[] interval : intervals)
        {
            if(res.size() == 0)
            {
                res.add(interval);
            }
            else
            {
                int[] prevInterval = res.get(res.size()-1);
                
                if(interval[0] <= prevInterval[1])
                {
                    prevInterval[1] = Math.max(prevInterval[1], interval[1]);
                }
                else
                {
                    res.add(interval);
                }
            }
        }
        return res.toArray(new int[0][]);      
    }
}

//217. Contains Duplicate
//https://leetcode.com/problems/contains-duplicate/

class duplicateCheck{
    public boolean containsDuplicate(int[] nums) {
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i<nums.length; i++)
        {
            if(!set.contains(nums[i]))
            {
                set.add(nums[i]);
            }
            else
            {
                return true;
            }
        }
        return false;        
    }
}

//Minimum indexed character 
//https://practice.geeksforgeeks.org/problems/minimum-indexed-character-1587115620/1/?track=md-hashing&batchId=144#

class minimumIndexChar
{
    //Function to find the minimum indexed character.
    public static int minIndexChar(String str, String patt)
    {
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0; i<str.length(); i++)
        {
            if(!map.containsKey(str.charAt(i)))
            {
                map.put(str.charAt(i), i);
            }
        }
        
        int res = Integer.MAX_VALUE;
        int flag = 0;
        for(int i = 0; i<patt.length(); i++)
        {
            if(map.containsKey(patt.charAt(i)))
            {
                res = Math.min(map.get(patt.charAt(i)), res);
                flag++;
            }
        }
        if(flag>0)
        {
            return res;
        }
        return -1;
    }
}

//76. Minimum Window Substring
//https://leetcode.com/problems/minimum-window-substring/

//TLE in GFG but accepted in LeetCode
class Solution{
    public String minWindow(String s, String p) {
        
        String res = "";
        
        HashMap<Character, Integer> mapP = new HashMap<>();
        //frequency map
        for(int i = 0; i<p.length(); i++)
        {
            char ch = p.charAt(i);
            mapP.put(ch, mapP.getOrDefault(ch, 0) + 1);
        }
        
        int i = -1;
        int j = -1;
        int curCount = 0;
        int desiredCount = p.length();
        
        HashMap<Character, Integer> mapS = new HashMap<>();
        
        while(true)
        {
            boolean loop1 = false;
            boolean loop2 = false;
            //acquire
            while(i < s.length() - 1 && curCount < desiredCount)
            {
                i++;
                char ch = s.charAt(i);
                mapS.put(ch, mapS.getOrDefault(ch,0)+1);
                
                
                if(mapS.getOrDefault(ch,0) <= mapP.getOrDefault(ch,0))
                {
                    curCount++;
                }
                loop1 = true;
            }
            
            //collect answer and release 
            while(j<i && curCount == desiredCount)
            {
                String potAns = s.substring(j+1, i+1);
                
                if(res.length() == 0 || potAns.length() < res.length())
                {
                    res = potAns;
                }
                
                j++;
                char ch = s.charAt(j);
                if(mapS.get(ch) == 1)
                {
                    mapS.remove(ch);
                }
                else
                {
                    mapS.put(ch, mapS.get(ch)-1);
                }
                
                if(mapS.getOrDefault(ch, 0) < mapP.getOrDefault(ch, 0))
                {
                    curCount--;
                }
                loop2 = true;
            }
            if(loop1 == false && loop2 == false)
            {
                break;
            }
        }
        
        return res;
        
    }
}
