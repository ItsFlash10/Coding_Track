package Day20;
import java.util.*;

//239. Sliding Window Maximum
//https://leetcode.com/problems/sliding-window-maximum/
//Maximum of all subarrays of size k 
//https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        while(j < n)
        {
            while(!dq.isEmpty() && dq.peekLast() < arr[j])
            {
                dq.pollLast();
            }
            dq.add(arr[j]);
            
            if(j-i+1 == k)
            {
                res.add(dq.peekFirst());
                
                if(dq.peekFirst() == arr[i])
                {
                    dq.pollFirst();
                }
                i++;
            }
            j++;
        }
        return res;
    }
}

//Zero Sum Subarrays 
//https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1/?track=md-hashing&batchId=144#

class zeroSubArrays{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put((long)0,1);
        long sum = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (map.containsKey(sum)) 
            {
                res += map.get(sum);
                map.put(sum,map.get(sum)+1);
            }
            else
            {
                map.put(sum,1);
            }
        }
        return res;
    }
}