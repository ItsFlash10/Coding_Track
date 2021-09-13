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

//Find first repeated character
//https://practice.geeksforgeeks.org/problems/find-first-repeated-character4108/1/?track=md-hashing&batchId=144#

class repChar 
{ 
    String firstRepChar(String s) 
    { 
        HashSet<Character> map = new HashSet<>();
        String res = "";
        
        for(int i = 0; i<s.length(); i++)
        {
            if(map.contains(s.charAt(i)))
            {
                res += s.charAt(i);
                return res;
            }
            map.add(s.charAt(i));
        }
        return "-1";
    }
} 

// Common elements
//https://practice.geeksforgeeks.org/problems/common-elements1132/0/?track=md-hashing&batchId=144#

class cmnEle
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        ArrayList<Integer> intersection = new ArrayList<>();
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i<n1 && j<n2 && k<n3)
        {
            if(A[i] == B[j] && B[j] == C[k])
            {
                if(!intersection.contains(A[i]))
                {
                    intersection.add(A[i]);
                }
                i++; j++; k++;
            }
            else if(A[i] < B[j]) i++;
            else if(B[j] < C[k]) j++;
            else k++;
        }
        return intersection;
    }
}

// Two Sum(GFG)
//https://practice.geeksforgeeks.org/problems/key-pair1554/0/?track=md-hashing&batchId=144#

class twoSum
{
    // A[] : the input array of positive integers
    // N : size of the array arr[]
    // X : the required sum
    public boolean keypair(int[] A, int N, int X)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<N; i++)
        {
            if(map.containsKey(X-A[i]))
            {
                return true;
            }
            map.put(A[i], i);
        }
        return false;
    }
}