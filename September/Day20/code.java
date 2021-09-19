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