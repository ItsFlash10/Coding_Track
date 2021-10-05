package Day6;

//278. First Bad Version
//https://leetcode.com/problems/first-bad-version/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class BSImpli{
    static int firstBadVersion(int n) {
        
        int i = 1;
        int j = n;
        
        while(i<j)
        {
            int mid = i + (j-i)/2;
            
            if(isBadVersion(mid))
            {
                j = mid;
            }
            else
            {
                i = mid + 1;
            }
        }
        return i;
        
    }
    //added to solve error
    private static boolean isBadVersion(int mid) {
        return false;
    }
}

//35. Search Insert Position
//https://leetcode.com/problems/search-insert-position/

class findPosi{
    public int searchInsert(int[] nums, int target) {
        
        int left = 0;
        int right = nums.length-1;
        int res = nums.length; //to take care of boundary case
        
        // if(target<nums[left])return left;
        // if(target>nums[right])return right+1;
        
        while(left <= right)
        {
            int mid = left + (right-left)/2;
            
            if(nums[mid] < target) left = mid + 1;
            else if(nums[mid] > target)
            {
                right = mid - 1; 
                res = mid; 
            }
            else
            {
                return mid;   
            }
        }
        return res;
    }
}

//31. Next Permutation
//https://leetcode.com/problems/next-permutation/submissions/

class nxtPer {
    public void nextPermutation(int[] nums) {
        
        if(nums.length <= 1 || nums == null) return;
        
        int right = nums.length - 2;
        
        while(right >= 0  && nums[right] >= nums[right + 1]) right--;
        if(right >= 0)
        {
            int j = nums.length-1;
                
            while(nums[j] <= nums[right]) j--;
            swap(nums, right, j);
        }
        
        reverse(nums, right+1, nums.length-1);
        
    }
    
    static void swap(int[] arr, int a, int b)
    {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    
    static void reverse(int[] arr, int i, int j)
    {
        while(i < j)
        {
            swap(arr, i++, j--);            
        }
    }
    
}