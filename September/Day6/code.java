package Day6;
import java.util.*;

//1. Longest consecutive subsequence
//https://practice.geeksforgeeks.org/problems/longest-consecutive-subsequence2449/1/?track=md-arrays&batchId=144#

class longestSubsequence
{   
    // arr[] : the input array
    // N : size of the array arr[]
    
    //Function to return length of longest subsequence of consecutive integers.
	static int findLongestConseqSubseq(int arr[], int N)
	{
	    HashSet<Integer> map = new HashSet<>();
	    
	    for(int num : arr)
	    {
	        map.add(num);
	    }
	    
	    int ans = 0;
	    
	    for(int num : arr)
	    {
	        if(!map.contains(num-1))
	        {
	            int curr_num = num;
	            int curr_max = 1;
	            
	            while(map.contains(curr_num + 1))
	            {
	                curr_max += 1;
	                curr_num += 1;
	            }
	            ans = Math.max(ans, curr_max);
	        }
	    }
	    return ans;
	}
}

