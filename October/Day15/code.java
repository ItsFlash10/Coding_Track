package Day15;

//No. of paths(Recursion)
//https://practice.geeksforgeeks.org/problems/number-of-paths0926/1/?track=md-recursion&batchId=144
class Solution{
    
    long numberOfPaths(int m, int n) {
        if(m<=0 || n<=0) return 0;
        if(m==1 && n==1) return 1;
        return numberOfPaths(m-1, n)+numberOfPaths(m, n-1);
    }
}
