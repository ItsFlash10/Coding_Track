package Day27;

//238. Product of Array Except Self
//https://leetcode.com/problems/product-of-array-except-self/

class proExSel {
    public int[] productExceptSelf(int[] nums) {
        
        int n = nums.length;
        
        long[] left = new long[n];
	    long[] right = new long[n];
	    int[] ans = new int[n];
	    
	    left[0] = 1;
	    right[n-1] = 1;
	    
	    for(int i = 1; i < n; i++)
	    {
	        left[i] = nums[i-1]*left[i-1];
	    }
	    
	    for(int i = n-2; i >= 0; i--)
	    {
	        right[i] = nums[i+1]*right[i+1];
	    }
	    
	    for(int i = 0; i < n; i++)
	    {
	        ans[i] = (int)(left[i]*right[i]);
	    }
	    
	    return ans; 
    }
}