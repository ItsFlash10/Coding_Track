package Day21;

//231. Power of Two

class Solution {
    public boolean isPowerOfTwo(int n) {
        
        if((n & (n-1)) == 0 && n > 0) return true;
        
        return false;
    }
}
