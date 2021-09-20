package Day21;

import java.util.*;

//Array Pair Sum Divisibility Problem
//https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/0/?track=md-hashing&batchId=144#

class Solution {
    public boolean canPair(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele : nums)
        {
            int rem = ele%k;
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        
        for(int val : nums)
        {
            int rem = val % k; 
            //if rem is 0 then the freq of that value of rem must be even
            if(rem == 0)
            {
                if(map.get(rem) % 2 == 1)
                {
                    return false;
                }
            }
            
            //if rem is k/2 then the freq of that value of rem must be even as well
            //rem == k/2 odd ke liye kaam ni krega isliye waise likha hai
            else if(2*rem == k)
            {
                if(map.get(rem) % 2 == 1)
                {
                    return false;
                }
            }
            
            //if rem is x then there must exist k-x
            else
            {
                if(map.get(rem) != map.get(k-rem))
                {
                    return false;
                }
            }
        }
        return true;
    }
}
