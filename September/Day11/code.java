package Day11;
import java.util.*;

//1. Three sum closest
//https://practice.geeksforgeeks.org/problems/three-sum-closest/1/?track=md-arrays#

class Solution 
{ 
    static int threeSumClosest(int[] Arr, int target)  
	{ 
	    
	    Arrays.sort(Arr);
        int closest_sum = Integer.MAX_VALUE;
	    int temp_sum = 0;
	    
	    for(int i = 0; i<Arr.length; i++)
	    {
	        int start = i + 1;
	        int end = Arr.length - 1;
	    
	        while(start < end)
	        {
	            temp_sum = Arr[i] + Arr[start] + Arr[end];
	            
	            if(Math.abs(target-temp_sum) < Math.abs(target-closest_sum))
	            {
	                closest_sum = temp_sum;
	            }
	            
	            if(temp_sum > target)
	            {
	                end--;
	            }
	            else
	            {
	                start++;
	            }
	        }
	    }
	    
	    return closest_sum;
        
    }
}
        