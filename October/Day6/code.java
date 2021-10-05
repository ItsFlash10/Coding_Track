package Day6;

//278. First Bad Version
//https://leetcode.com/problems/first-bad-version/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

class BSImpli{
    static int firstBadVersion(int n) {
        
        int i = 1;
        int j = n;
        
        while(i<j)
        {
            int mid = i + (j-i)/2;
            
            if(isBadVersion(mid))
            {
                j = mid;
            }
            else
            {
                i = mid + 1;
            }
        }
        return i;
        
    }
    //added to solve error
    private static boolean isBadVersion(int mid) {
        return false;
    }
}