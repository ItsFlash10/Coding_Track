package Day19;

//461. Hamming Distance
//https://leetcode.com/problems/hamming-distance/

class hamDis {
    public int hammingDistance(int x, int y) {
        
        int res = 0;
        
        while(x > 0 || y > 0)
        {
            res = (x % 2)^(y % 2);
            
            x >>= 1;
            y >>= 1;
        }
        
        return res;        
    }
}
