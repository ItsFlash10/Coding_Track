package Day17;

//62. Unique Paths
//https://leetcode.com/problems/unique-paths/

class unqPaths {
    public int uniquePaths(int m, int n) 
    {
        int[][] grid = new int[m][n];
        for(int i = 0; i<m; i++)
        {
            for(int j = 0; j<n; j++)
            {
                if(i==0||j==0)
                    grid[i][j] = 1;
                else
                    grid[i][j] = grid[i][j-1] + grid[i-1][j];
            }
        }
        return grid[m-1][n-1];
    }
}

//Using Modified Binary Search

class PPSolu{
    public int singleNonDuplicate(int[] nums) {
        
        int n = nums.length;
        if(nums.length == 1) return nums[0];
        if(nums[0] != nums[1]) return nums[0];
        if(nums[n-1] != nums[n-2]) return nums[n-1];
        
        int high = n-1;
        int low = 0;
        
        while(low <= high)
        {
            int mid = low + (high-low)/2;
            
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
            {
                return nums[mid];
            }
            
            else if(nums[mid] == nums[mid - 1])
            {
                //count to find the odd side
                int leftCount = mid - low + 1;
                
                if(leftCount % 2 == 0)
                {
                    low = mid + 1;
                }
                else
                {
                    high = mid - 2;
                }
            }
            
            else if(nums[mid] == nums[mid + 1])
            {
                //count to find the odd side
                int rightCount = high - mid + 1;
                
                if(rightCount % 2 == 0)
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid - 2;
                }
            }
        }
        return 0;
    }
}
