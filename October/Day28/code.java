package Day28;
import java.util.*;

//215. Kth Largest Element in an Array
//https://leetcode.com/problems/kth-largest-element-in-an-array/

class Solution {
    public int findKthLargest(int[] nums, int k) {
                
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        k = nums.length - k;
        
        while (start < end) {
            int pivot = partition(nums, start, end);
            if (pivot < k) start = pivot + 1; 
            else if (pivot > k) end = pivot - 1;
            else return nums[pivot];
        }
        return nums[start];      
    }
    
    int partition(int[] nums, int start, int end)
    {
        int pivot = start;
        while(start <= end)
        {
            while (start <= end && nums[start] <= nums[pivot]) start++;
            while (start <= end && nums[end] > nums[pivot]) end--;
            
            if(start < end)
            {
                swap(nums, start, end);
            }
        }
        swap(nums, pivot, end);
        return end;
    }
    
    void swap(int[] nums, int a, int b)
    {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}
