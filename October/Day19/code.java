package Day19;

//191. Number of 1 Bits
//https://leetcode.com/problems/number-of-1-bits/

class answer{
    public int hammingWeight(int n) {
        
        int ones = 0;
        
        while(n!=0)
        {
            ones += n & 1;
            n = n >>> 1;
        }
        return ones;
    }
}