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

//First negative integer in every window of size k 
//https://practice.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1#

class firstNegativeInWindow{
    
    public long[] printFirstNegativeInteger(long A[], int N, int K)
    {
        int i = 0;
        int j = 0;
        long[] res = new long[N-K+1];
        ArrayList<Long> range = new ArrayList<>();
        
        while(j < N)
        {
            if(A[j] < 0)
            {
                range.add(A[j]);
            }

            if(j-i+1 == K)
            {
                if(range.size() == 0)
                {
                    res[i] = 0;
                }
                else if(A[i] == range.get(0))
                {
                    res[i] = range.remove(0);
                }
                else
                {
                    res[i] = range.get(0);
                }
                i++;
            }
            j++;
        }
        return res;
    }
}
