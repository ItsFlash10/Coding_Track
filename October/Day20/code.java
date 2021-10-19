package Day20;

//268. Missing Number
//https://leetcode.com/problems/missing-number/

class missingNum {
    public int missingNumber(int[] nums) {
        
        int res = nums.length;
        
        for(int i = 0; i < nums.length; i++)
        {
            res = res ^ i;
            res = res ^ nums[i];
        }
        return res;        
    }
}
