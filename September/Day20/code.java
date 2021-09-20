package Day20;
import java.util.*;

//239. Sliding Window Maximum
//https://leetcode.com/problems/sliding-window-maximum/
//Maximum of all subarrays of size k 
//https://practice.geeksforgeeks.org/problems/maximum-of-all-subarrays-of-size-k3101/1

class Solution
{
    //Function to find maximum of each subarray of size k.
    static ArrayList <Integer> max_of_subarrays(int arr[], int n, int k)
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        
        while(j < n)
        {
            while(!dq.isEmpty() && dq.peekLast() < arr[j])
            {
                dq.pollLast();
            }
            dq.add(arr[j]);
            
            if(j-i+1 == k)
            {
                res.add(dq.peekFirst());
                
                if(dq.peekFirst() == arr[i])
                {
                    dq.pollFirst();
                }
                i++;
            }
            j++;
        }
        return res;
    }
}

//Zero Sum Subarrays 
//https://practice.geeksforgeeks.org/problems/zero-sum-subarrays1825/1/?track=md-hashing&batchId=144#

class zeroSubArrays{
    //Function to count subarrays with sum equal to 0.
    public static long findSubarray(long[] arr ,int n) 
    {
        HashMap<Long, Integer> map = new HashMap<>();
        map.put((long)0,1);
        long sum = 0;
        int res = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if (map.containsKey(sum)) 
            {
                res += map.get(sum);
                map.put(sum,map.get(sum)+1);
            }
            else
            {
                map.put(sum,1);
            }
        }
        return res;
    }
}

//209. Minimum Size Subarray Sum
//https://leetcode.com/problems/minimum-size-subarray-sum/

class minimumSubArray {
    public int minSubArrayLen(int target, int[] nums) {
        
        int res = Integer.MAX_VALUE;
        
        int i = 0;
        int j = 0;
        int sum = 0;
        
        while(j < nums.length)
        {
            sum += nums[j];
            
            if(sum < target)
            {
                j++;    
            }
                        
            else if(sum >= target)
            {
                while(sum >= target)
                {
                    res = Math.min(res, j-i+1);

                    sum -= nums[i];
                    i++;
                }
                j++;
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

//560. Subarray Sum Equals K
//https://leetcode.com/problems/subarray-sum-equals-k/

class sumOfSubArray{
    public int subarraySum(int[] arr, int k) {
        
        int res = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        
        for(int i = 0; i<arr.length; i++)
        {
            sum += arr[i];
            
            if(map.containsKey(sum-k))
            {
                res += map.get(sum-k);
            }
            map.put(sum, map.getOrDefault(sum,0)+1);
        }
        return res;
    }
}

//992. Subarrays with K Different Integers
//https://leetcode.com/problems/subarrays-with-k-different-integers/

class kDiffInt{
    public int subarraysWithKDistinct(int[] nums, int k) {
        
        return (atMostK(nums, k) - atMostK(nums, k - 1));
    }
    
    static int atMostK(int nums[], int k)
    {
        int count = 0;
        
        HashMap<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
              
        while(j < nums.length)
        {
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            
            while(map.size() > k)
            {
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i]) == 0)
                {
                    map.remove(nums[i]);
                }
                i++;
            }
            
            count += j-i+1;
            j++;
        }
        return count;        
    }
}

//Longest subarray with sum divisible by K 
//https://practice.geeksforgeeks.org/problems/longest-subarray-with-sum-divisible-by-k1259/0/?track=md-hashing&batchId=144#

class subArrayDivByK{
    int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int sum = 0;
        
        for(int i = 0; i<n; i++)
        {
            sum += a[i];
            int rem = sum%k;
            
            //the only difference cozzz -ve sum mein -5 aur 2 are similar for k = 7
            if(rem < 0)
            {
                rem = rem + k;
            }
            
            if(map.containsKey(rem))
            {
                res = Math.max(res, i-map.get(rem));
            }
            else{
                map.put(rem, i);
            }
        }
        return res;
    }
}

//Sort an array according to the other 
//https://practice.geeksforgeeks.org/problems/relative-sorting4323/0/?track=md-hashing&batchId=144#
 
class sortWRTA2{
    public static int[] sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        int[] res = new int[N];
        int k = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i<N; i++)
        {
            map.put(A1[i], map.getOrDefault(A1[i],0)+1);
        }
        //adding ele according to A2 in the res and removing it from the map
        for(int i = 0; i<M; i++)
        {
            if(map.containsKey(A2[i]))
            {
                for(int j = 0; j<map.get(A2[i]); j++)
                {
                    res[k++] = A2[i];
                }
                map.remove(A2[i]);
            }
        }
        
        Arrays.sort(A1);
        //adding the remaining ele into the result after sorting it
        for(int i = 0; i<N; i++)
        {
            if(map.containsKey(A1[i]))
            {
                res[k++] = A1[i];
            }
        }
        
        return res;
    }
}

// Print Anagrams Together
//https://practice.geeksforgeeks.org/problems/print-anagrams-together/0/?track=md-hashing&batchId=144

class anagramsTogether{
    public List<List<String>> Anagrams(String[] string_list) {
        
        ArrayList<List<String>> res = new ArrayList<>();
        //map for freq and the string  && HashMap can be KEY of a HashMap
        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        
        for(String str : string_list)
        {
            HashMap<Character, Integer> freqMap = new HashMap<>();
            
            for(int i =0;i <str.length(); i++)
            {
                char ch = str.charAt(i);
                freqMap.put(ch, freqMap.getOrDefault(ch,0)+1);
            }
            
            if(!map.containsKey(freqMap))
            {
                ArrayList<String> list = new ArrayList<>();
                list.add(str);
                map.put(freqMap, list);
            }
            else
            {
                ArrayList<String> list = map.get(freqMap); //area to focus
                list.add(str);
            }
        }
        
        for(ArrayList<String> val : map.values())
        {
            res.add(val);
        }
        return res;
    }
}