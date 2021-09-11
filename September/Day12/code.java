package Day12;

//1827. Minimum Operations to Make the Array Increasing
//https://leetcode.com/problems/minimum-operations-to-make-the-array-increasing/

class minOpperationToInc{
    public int minOperations(int[] nums) {
        
        int count = 0;
        if(nums.length <= 1)
        {
            return 0;
        }
        
        int num = nums[0];
        
        for(int i = 1; i < nums.length; i++)
        {
            if(num == nums[i])
            {
                num++;
                count++;
            }
            else if(num > nums[i])
            {
                num++;
                count += num - nums[i];
            }
            else
            {
                num = nums[i];
            }
        }
        
        return count;
    }
}
