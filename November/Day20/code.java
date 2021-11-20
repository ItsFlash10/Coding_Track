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

//BS X BitsMan.
// Note: How can you implement the check operation. Remember the xor operation, and if you xor any number with 1, then it flips the LSB (Least significant bit)
// Ex. 1) 100^1=101 [i.e 4^1=5, flips the first bit from right side]
//     2) 101^1=100 [i.e 5^1=4, again flips the first bit from right side]
// So, if I is even, to find the next element we do I^1
// and if I is odd, to find the previous element we do I^1

class bSxBM {
    public int singleNonDuplicate(int[] nums) {
        int l = 0;
        int h = nums.length - 1;
        while (l < h) {
            int m = (l + h) / 2;
            if (nums[m] == nums[m ^ 1]) {
                l = m + 1;
            } else {
                h = m;
            }
        }
        return nums[h];
    }
}
