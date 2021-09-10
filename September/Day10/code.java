package Day10;

//1. Find the next prime
// https://practice.geeksforgeeks.org/problems/next-prime-number/1#
class nextPrimeNo{

    public static int nextPrime(int n)
    {
        
        int num = n + 1;
        
        while(n<Integer.MAX_VALUE)
        {
            int count = 0;
            for(int div = 2; div*div <= num; div++)
            {
                if(num%div == 0)
                {
                    count++;
                }
            }
            if(count == 0)
            {
                return num;
            }
            else
            {
                num++;
                continue;
            }
        }
        return 0;
        
        
    }
}

//2. Max Circular Subarray Sum 
//https://practice.geeksforgeeks.org/problems/max-circular-subarray-sum-1587115620/0/?track=md-arrays&batchId=144

class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int a[], int n) {
        
        int max_straight_sum = Integer.MIN_VALUE;
        int temp_max_sum = 0;
        
        int min_straight_sum = Integer.MAX_VALUE;
        int temp_min_sum = 0;
        
        int arraySum = 0;
        
        for(int i = 0; i<n; i++)
        {
            temp_max_sum += a[i];
            max_straight_sum = Math.max(temp_max_sum, max_straight_sum);
            
            if(temp_max_sum < 0)
            {
                temp_max_sum = 0;
            }
            
            temp_min_sum += a[i];
            min_straight_sum = Math.min(temp_min_sum, min_straight_sum);
            
            if(temp_min_sum > 0)
            {
                temp_min_sum = 0;
            }
            
            arraySum += a[i];
        }
        
        if(min_straight_sum == arraySum)
        {
            return max_straight_sum;
        }
        else
        {
            return Math.max((arraySum-min_straight_sum),max_straight_sum);
        }
        
        
        
        // return Integer.max(kadane(a,n), reverseKadane(a,n));
    }
    
}