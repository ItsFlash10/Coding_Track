package Day8;
import java.util.*;


//1. K-th element of two sorted Arrays
// https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array1317/1/?track=md-arrays&batchId=144#

class Solution {
    
    public long kthElement( int arr1[], int arr2[], int n, int m, int k) {

        int[] res = new int[n+m];
        
        int i = 0;
        for(i = 0; i<n; i++)
        {
            res[i] = arr1[i];
        }
        
        for(int j = 0; j<m; j++)
        {
            res[i] = arr2[j];
            i++;
        }
        
        Arrays.sort(res);
        
        return res[k-1];
    }
}

//2. 