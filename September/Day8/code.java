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

//2. Maximum value of difference of a pair of elements and their Index
// https://practice.geeksforgeeks.org/problems/maximum-value-of-difference-of-a-pair-of-elements-and-their-index/1/?track=md-arrays&batchId=144#

class diffPair{
    static int maxValue(int[] arr, int n) {
        
        // open the mod and there'll be just two expressions arr[i]+i and i-arr[i]
        // after that just get the max and min and subtract min to max to get max
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;
        
        for(int i = 0; i<n; i++)
        {
            max1 = Math.max(max1, (arr[i]+i));
            min1 = Math.min(min1, (arr[i]+i));
            
            max2 = Math.max(max2, (i-arr[i]));
            min2 = Math.min(min2, (i-arr[i]));
        }
        
        int ans = Math.max(max1-min1, max2-min2);
        
        return ans;
        
        //Brute Force
        // int ans = 0;
        
        // for(int i = 0; i<N; i++)
        // {
        //     for(int j = i+1; j<N; j++)
        //     {
        //         ans = Math.max(ans, Math.abs(arr[i]-arr[j])+Math.abs(i-j));
        //     }
        // }
        // return ans;
    }
};