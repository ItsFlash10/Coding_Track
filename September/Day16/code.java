package Day16;
import java.util.*;

//Max Sum Subarray of size K 
//https://practice.geeksforgeeks.org/problems/max-sum-subarray-of-size-k5313/1#

class maxSubArrayInK{
    static int maximumSumSubarray(int K, ArrayList<Integer> Arr,int N){
       
        int i = 0;
        int j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
       
       while(j<N)
       {
           sum += Arr.get(j);

           if(j-i+1 < K)
           {
               j++;
           }
           else if(j-i+1 == K)
           {
               max = Math.max(sum, max);
               sum = sum - Arr.get(i);
               i++;
               j++;
           }
       }
       return max;
    }
}
