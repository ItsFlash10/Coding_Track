package Day20;

//540. Single Element in a Sorted Array
//https://leetcode.com/problems/single-element-in-a-sorted-array/

class xorSol{
    public int singleNonDuplicate(int[] nums) 
    {
        int res = nums[0];
        
        for(int i = 1; i<nums.length; i++)
        {
            res = res ^ nums[i];
        }
        
        return res;
    }
}
