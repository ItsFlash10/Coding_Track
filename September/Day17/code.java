import java.util.*;

//Longest Sub-Array with Sum K 
//https://practice.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1#

class Solution{

    public static int lenOfLongSubarr (int arr[], int n, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0, maxLen = 0;
 
        for (int i = 0; i < n; i++) {
                 
            sum += arr[i];
                 
            if (sum == k)
                maxLen = i + 1;
 
            if (!map.containsKey(sum)) 
            {
                map.put(sum, i);
            }
 
            if (map.containsKey(sum - k)) 
            {
                maxLen = Math.max(maxLen, i - map.get(sum - k));
            }
        }
        return maxLen;            
    }
}
