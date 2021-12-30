package Day30;

//1015. Smallest Integer Divisible by K
//https://leetcode.com/problems/smallest-integer-divisible-by-k/

class smlIntdivByK {
    public int smallestRepunitDivByK(int k) {
        if(k%2==0 || k%5==0)
            return -1;
        int rem=0;//to calculate previous rem
        for(int i=1;i<=k;i++)
        {
            rem=(rem*10+1)%k;
            if(rem==0)
                return i;
        }
        return -1;   
    }
}
