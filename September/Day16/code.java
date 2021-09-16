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

//Count Occurences of Anagrams 
//https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1#

class anagrams{

    int search(String pat, String txt) {
        
        int res = 0;
        
        int k = pat.length();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(int i = 0; i<pat.length(); i++)
        {
            char ch = pat.charAt(i);
            map.put(ch, map.getOrDefault(ch,0) + 1);
        }
        // System.out.print(map.entrySet()+" "+map.size()+" "+k);
        
        int i = 0;
        int j = 0;
        int count = map.size();
        
        while(j < txt.length())
        {
            char ch = txt.charAt(j);
            if(map.containsKey(ch))
            {
                map.put(ch, map.getOrDefault(ch,0) - 1);
                if(map.get(ch) == 0)
                {
                    count--;
                }
            }
            
            if(j-i+1 == k)
            {
                if(count == 0)
                {
                    res++;
                }

                if(map.containsKey(txt.charAt(i)))
                {
                    map.put(txt.charAt(i), map.getOrDefault(txt.charAt(i),0)+1);
                        
                    if(map.get(txt.charAt(i)) == 1)
                    {
                        count++;
                    }
                }
                i++;
            }
            j++;
        }
        return res;
    }
}

//Largest subarray with 0 sum 
//https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1

class maxLength
{
    int maxLen(int arr[], int n)
    {
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        int maxi = 0;
        
        for(int i = 0; i<n; i++)
        {
            sum += arr[i];
            if(sum == 0)
            {
                maxi = i+1;
            }
            else
            {
                if(map.get(sum) != null)
                {
                    maxi = Math.max(maxi, i - map.get(sum));
                }
                else
                {
                    map.put(sum, i);
                }
            }
        }
        return maxi;

    }
}

//Largest subarray of 0's and 1's  **THIS SAME AS ABOVE(PATTTERN)
//https://practice.geeksforgeeks.org/problems/largest-subarray-of-0s-and-1s/1/?track=md-hashing&batchId=144#

class Solution {

    // arr[] : the input array containing 0s and 1s
    int maxLen(int[] arr, int N)
    {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        
        for(int i = 0; i<N; i++)
        {
            if(arr[i] == 1) sum += 1; //treating 1 as +1
            
            else if(arr[i] == 0) sum -= 1; //treating 0 as -1
            
            if(sum == 0)
            {
                res = i + 1;
            }
            else
            {
                if(map.containsKey(sum))
                {
                    res = Math.max(res, i - map.get(sum));
                }
                else
                {
                    map.put(sum, i);
                }
            }
        }
        return res;
    }
}
