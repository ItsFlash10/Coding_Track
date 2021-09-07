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

//2. Searching an element in a sorted array (Ternary Search)
//https://practice.geeksforgeeks.org/problems/3d27d4683c121c1f152ee8f41279255dc4430cf6/1/?track=md-design&batchId=144#


//NAIVE SOLUTION TO FIND AN ELEMENT
class ternSearch{

    static int ternarySearch(int arr[], int N, int K)
    {
        int start = 0;
        int end = arr.length-1;
        
        while(start <= end)
        {
            int mid1 = start + (end-start)/3;  
            int mid2 = end - (end-start)/3;  
            
            if(arr[mid1] == K || arr[mid2] == K)
            {
                return 1;
            }
            
            if(arr[mid1] > K)
            {
                end = mid1 - 1;
            }
            else if(arr[mid2] < K)
            {
                start = mid2 + 1;
            }
            else
            {
                start = mid1 + 1;
                end = mid2 - 1;
            }
        }
        
        return -1;
        
        // for(int i = 0; i<arr.length; i++)
        // {
        //     if(arr[i] == K)
        //     {
        //         return 1;
        //     }
        // }
        // return -1;
    }
}
