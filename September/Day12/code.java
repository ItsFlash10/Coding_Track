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

//918. Maximum Sum Circular Subarray
//https://leetcode.com/problems/maximum-sum-circular-subarray/

class circularMax{
    public int maxSubarraySumCircular(int[] nums) {
        
        int straightMaxSum = Integer.MIN_VALUE;
        int straightMinSum = Integer.MAX_VALUE;
        int tempMax = 0;
        int tempMin = 0;
        int arraySum = 0;
        
        for(int i = 0; i < nums.length; i++)
        {
            tempMax += nums[i];
            straightMaxSum = Math.max(tempMax, straightMaxSum);
            if(tempMax < 0)
            {
                tempMax = 0;
            }
            
            tempMin += nums[i];
            straightMinSum = Math.min(tempMin, straightMinSum);
            if(tempMin > 0)
            {
                tempMin = 0;
            }
            
            arraySum += nums[i];
        }
        
        if(arraySum == straightMinSum)
        {
            return straightMaxSum;
        }

        return Math.max((arraySum-straightMinSum), straightMaxSum);

    }
}
