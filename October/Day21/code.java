package Day21;

//11. Container With Most Water
//https://leetcode.com/problems/container-with-most-water/

class maxAreaContainer {
    public int maxArea(int[] height) {
        
        int len = height.length;
        int right = len - 1;
        int left = 0;
        int res = 0;
        
        while(left < right)
        {
            if(height[left] < height[right])
            {
                res = Math.max(res, height[left] * (right - left));
                left++;                
            }
            else
            {
                res = Math.max(res, height[right] * (right - left));                
                right--;
            }
        }
        return res;        
    }
}