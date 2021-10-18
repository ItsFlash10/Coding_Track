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

//190. Reverse Bits
//https://leetcode.com/problems/reverse-bits/submissions/

class revBits{
    public int reverseBits(int n) {
        
        int rev=0;
        
        for(int i=0;i<32;i++)
        {
            rev= (rev << 1) | (n & 1);         
            n = n >> 1;                  
        }
        return rev;
    }
}