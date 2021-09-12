package Day13;

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
