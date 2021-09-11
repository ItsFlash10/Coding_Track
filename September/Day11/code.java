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
	            
	            if(Math.abs(1L*target-temp_sum) < Math.abs(1L*target-closest_sum))
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
       

//2. Trapping Rain Water
//https://practice.geeksforgeeks.org/problems/trapping-rain-water-1587115621/1/?track=md-arrays&batchId=144

class rainWater{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        
        int left = 0;
        int right = n-1;
        
        int leftMax = 0;
        int rightMax = 0;
        long res = 0;
        
        while(left <= right)
        {
            if(arr[left] <= arr[right])
            {
                if(arr[left] >= leftMax)
                {
                    leftMax = arr[left];
                }
                else
                {
                    res += leftMax - arr[left];
                }
                left++;
            }
            else
            {
                if(arr[right] >= rightMax)
                {
                    rightMax = arr[right];
                }
                else
                {
                    res += rightMax - arr[right];
                }
                right--;
            }
            
        }
        return res;
    } 
}