package Day13;
import java.util.*;

//1. Triplet sum in an array
//https://practice.geeksforgeeks.org/problems/triplet-sum-in-array-1587115621/1#

class Solution
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public static boolean find3Numbers(int A[], int n, int X) { 
        
        
       Arrays.sort(A);    
       ArrayList<Integer> res = new ArrayList<>();
       
       for(int i = 0; i<n; i++)
       {
           int start = i+1;
           int end = n-1;
           int tempTarget = X-A[i];
           
           while(start < end)
           {
               int twoSum = A[start] + A[end];
               
               if(twoSum > tempTarget) end--;
               else if(twoSum < tempTarget) start++;
               
               else
               {
                   res.add(A[i]);
                   res.add(A[start]);
                   res.add(A[end]);
                   break;
               }
           }
       }
       if(res.size() == 0)
       {
           return false;
       }
       return true;
    
    }
}

// Stock buy and sell 
//https://practice.geeksforgeeks.org/problems/stock-buy-and-sell-1587115621/1/?track=md-arrays&batchId=144#

class stock{
    
    //Function to find the days of buying and selling stock for max profit.
    ArrayList<ArrayList<Integer> > stockBuySell(int A[], int n) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

        for(int i = 1; i<n; i++)
        {
            if(A[i]>=A[i-1])
            {
                ArrayList<Integer> pro = new ArrayList<>();
                pro.add(i-1);
                pro.add(i);
                res.add(pro);
            }
        }
        return res;
    }
}