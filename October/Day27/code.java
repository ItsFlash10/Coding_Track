package Day27;

//75. Sort Colors
//https://leetcode.com/problems/sort-colors/

class SolSort {
    public void sortColors(int[] nums) {
        
        int n = nums.length;
        int i = 0;
        int j = n-1;
        int mid = 0;
        
        while(mid<=j)
        {   
            if(nums[mid] == 0)
            {
                swap(nums, i, mid);
                i++;
                mid++;
            }
            
            else if(nums[mid] == 1)
            {
                mid++;
            }
            else
            {
                swap(nums, mid, j);
                j--;
            }
        }
    }
    void swap (int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}