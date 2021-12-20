package Day20;

//1200. Minimum Absolute Difference
//https://leetcode.com/problems/minimum-absolute-difference/

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        
        List<List<Integer>> res = new ArrayList();
        Arrays.sort(arr);
        int min = Integer.MAX_VALUE;
        
        for (int i = 0; i < arr.length - 1; i++) 
        {
            int diff = arr[i + 1] - arr[i];
            if (diff < min) 
            {
                min = diff;
                res.clear();
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            } 
            else if (diff == min) 
            {
                res.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }
        return res;
    }
}
