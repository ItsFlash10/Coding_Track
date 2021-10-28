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

class usingPQ {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        
        for(int num: nums)
        {
            minHeap.add(num);
            
            if(minHeap.size() > k)
            {
                minHeap.remove();
            }
        }
        return minHeap.peek();        
    }
}

//378. Kth Smallest Element in a Sorted Matrix
//https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/

class kthSmallestInAMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        
        // int matLen = matrix.length*matrix[0].length;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        
        for(int i = 0; i<matrix.length; i++)
        {
            for(int j = 0; j<matrix[0].length; j++)
            {
                maxHeap.add(matrix[i][j]);
                
                if(maxHeap.size() > k) maxHeap.poll();
            }
        }
        // while(maxHeap.size() > matLen - k + 1) maxHeap.remove();
        return maxHeap.peek();
    }
}