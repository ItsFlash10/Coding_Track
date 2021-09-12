package Day12;
import java.util.*;

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

//1. Two Sum/Key Pair(GFG)
//https://leetcode.com/problems/two-sum/

class keyPair{
    public int[] twoSum(int[] nums, int target) {
        
        int[] res = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(target-nums[i]))
            {
                res[0] = map.get(target-nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }
}

// 18. 4Sum
//https://leetcode.com/problems/4sum/

class quadSum{
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(nums == null || nums.length == 0)
            return res;
        
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0; i<nums.length; i++)
        {
            for(int j = i+1; j<nums.length; j++)
            {
                int start = j+1;
                int end = n-1;
                int tempTarget = target - nums[i] - nums[j];
                
                while(start<end)
                {
                    int twoSum = nums[start] + nums[end];
                    
                    if(tempTarget > twoSum)
                        start++;
                    
                    else if(tempTarget < twoSum) 
                        end--;
                    
                    else
                    {
                        ArrayList<Integer> quad = new ArrayList<>();
                        quad.add(nums[i]);
                        quad.add(nums[j]);
                        quad.add(nums[start]);
                        quad.add(nums[end]);
                        res.add(quad);
                        
                        while(start < end && nums[start] == quad.get(2)) 
                        {
                            start++;
                        }
                        
                        while(start < end && nums[end] == quad.get(3)) 
                        {
                            end--;
                        }
                    }
                }
                while(j+1 < n && nums[j+1] == nums[j]) j++;                   
            }
            while(i+1 <n && nums[i+1] == nums[i]) i++;
        }
        return res;
    }
}
