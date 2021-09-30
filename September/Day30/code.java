package Day30;

//Median of a 2D matrix using nested Binary Search
//https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1

class Solution {
    int countSmallerThanEqualToMid(int[] row, int mid)
    {
        int lo = 0;
        int hi = row.length-1;
        
        while(lo<=hi)
        {
            // int md = lo + (hi-lo)/2;
            int md = (lo + hi) >> 1;
            
            if(row[md] <= mid)
            {
                lo = md+1;
            }
            else
            {
                hi = md-1;
            }
        }
        return lo;
        
    }
    int median(int mat[][], int r, int c) {
        
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        
        while(low<=high)
        {
            // int mid = low + (high-low)/2;
            int mid = (high+low) >> 1;
            int count = 0;
            
            for(int i = 0; i<r; i++)
            {
                count += countSmallerThanEqualToMid(mat[i],mid);
            }
            
            if(count<=(r*c)/2)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return low;
    }
}

