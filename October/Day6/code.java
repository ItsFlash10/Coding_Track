package Day6;
import java.util.*;

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

//442. Find All Duplicates in an Array
//https://leetcode.com/problems/find-all-duplicates-in-an-array/

class dupWithoutExtraSpace{
    public List<Integer> findDuplicates(int[] nums) {
        
        //optimised[but will work for this particaular question][Nick White Method]
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i<nums.length; i++)
        {
            int idx = Math.abs(nums[i]) - 1; //since 1<=nums[i]<n we can manipulate idx and take it as a reference
            
            if(nums[idx] < 0) res.add(idx + 1); //if the val at a particular idx is -ve means we have visited it once
            
            nums[idx] = -nums[idx]; //after visiting just make the value negative
        }
        return res;
    
        
//         //better
//         ArrayList<Integer> res = new ArrayList<>();
//         HashSet<Integer> set = new HashSet<>();
        
//         for(int i = 0; i < nums.length; i++)
//         {
//             if(set.contains(nums[i]))
//             {
//                 res.add(nums[i]);
//             }
//             else
//             {
//                 set.add(nums[i]);
//             }
//         }
//         return res;
        
//        //same with boolean array
//         List<Integer> res = new ArrayList<>();
        
//         if (nums == null || nums.length == 0) {
//             return res;
//         }
//         int n = nums.length;
//         boolean[] visit = new boolean[n+1]; //since elem can appear at max twice
        
//         for(int i = 0; i<nums.length; i++)
//         {
//             if(visit[nums[i]])
//             {
//                 res.add(nums[i]);
//             }
//             visit[nums[i]] = true;
//         }
//         return res;
        
    }
}

//977. Squares of a Sorted Array
//https://leetcode.com/problems/squares-of-a-sorted-array/submissions/

class sortSquareArray {
    public int[] sortedSquares(int[] nums) {
        
        //(O(n))
        int[] res = new int[nums.length];
        int n = nums.length;
        int idx = n-1;
        int left = 0;
        int right = n-1;
        
        while(left <= right)
        {
            if(Math.abs(nums[left]) >= nums[right])
            {
                res[idx--] = nums[left] * nums[left];
                left++;
            }
            else
            {
                res[idx--] = nums[right] * nums[right];
                right--;
            }    
        }
        return res;
        
        
//         //O(n logn)
//         int[] res = new int[nums.length];
//         int idx = 0;
        
//         for(int i = 0; i<nums.length; i++)
//         {
//             res[idx++] = nums[i]*nums[i];
//         }
//         Arrays.sort(res);
        
//         return res;
        
    }
}

//189. Rotate Array
//https://leetcode.com/problems/rotate-array/

class rotationArr{
    public void rotate(int[] nums, int k) {
        
        int n = nums.length;
        
        if(nums == null || n == 1) return;
        
        k = k%n;
        k = n-k;
        reverse(nums,0, k-1);
        reverse(nums,k, n-1);
        reverse(nums, 0, n-1);
    }
    
    static void reverse(int[] arr, int i, int j)
    {
        
        while(i<j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            
            i++;
            j--;
        }
    }
}