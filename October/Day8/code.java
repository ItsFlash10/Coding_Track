package Day8;

//283. Move Zeroes
//https://leetcode.com/problems/move-zeroes/

class mvzro{
    public void moveZeroes(int[] nums) {
        
        if(nums == null || nums.length == 0) return;
        
        int left = 0;
        
        for(int i  = 0; i < nums.length; i++)
        {
            if(nums[i] != 0)
            {
                int temp = nums[left];
                nums[left] = nums[i];
                nums[i] = temp;
                
                left++;
            }
        }
        return;        
    }
}

//167. Two Sum II - Input array is sorted
//https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/

class idxSum{
    public int[] twoSum(int[] nums, int target) {
        
        int i = 0;
        int j = nums.length-1;
        int[] res = new int[2];
        
        while(i < j)
        {
            int sum = nums[i] + nums[j];
            
            if(sum > target)
            {
                j--;
            }
            else if(sum < target)
            {
                i++;
            }
            else
            {
                res[0] = i+1;
                res[1] = j+1;
                break;
            }
        }
        return res;           
    }
}