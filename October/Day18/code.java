package Day18;

//733. Flood Fill
//https://leetcode.com/problems/flood-fill/

class fillFlood{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        
        if(image[sr][sc] == newColor) return image;
        
        int rows = image.length;
        int cols = image[0].length;
        int source = image[sr][sc];
        
        dfs(image, sr, sc, newColor, rows, cols, source);
        
        return image;
    }
    
    void dfs(int[][] image, int sr, int sc, int newColor, int rows, int cols, int source)
    {
        if(sr<0 || sr >= rows || sc < 0 || sc >= cols) return;
        
        else if(image[sr][sc] != source) return;
        
        image[sr][sc] = newColor;
        
        //top
        dfs(image, sr-1, sc, newColor, rows, cols, source);
        //right
        dfs(image, sr, sc+1, newColor, rows, cols, source);
        //down
        dfs(image, sr+1, sc, newColor, rows, cols, source);
        //left
        dfs(image, sr, sc-1, newColor, rows, cols, source);
    }
}

//200. Number of Islands
//https://leetcode.com/problems/number-of-islands/

class countIslands{
    public int numIslands(char[][] grid) {
        
        int rows = grid.length;
        if(rows == 0) return 0; //edge case
        int cols = grid[0].length;
        
        int count = 0; //no. of islands
        
        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<cols; j++)
            {
                if(grid[i][j] == '1')
                {
                    markIslandBound(grid, i, j, rows, cols); //funstion to mark Island boundaries
                    count++;
                }
            }
        }
        return count;
    }
    
    void markIslandBound(char[][] grid, int i, int j, int rows, int cols)
    {
        if(i >= rows || i < 0 || j < 0 || j >= cols || grid[i][j] != '1') return;
        
        grid[i][j] = '2'; //mark as visited by 2
        
        //top
        markIslandBound(grid, i-1, j, rows, cols);        
        //right
        markIslandBound(grid, i, j+1, rows, cols);
        //down
        markIslandBound(grid, i+1, j, rows, cols);
        //left
        markIslandBound(grid, i, j-1, rows, cols);
    }
}

//993. Cousins in Binary Tree
//https://leetcode.com/problems/cousins-in-binary-tree/

//Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
class Solution {
    int level = 0;
    TreeNode savedParent= null;
    
    public boolean isCousins(TreeNode root, int x, int y) {
        
        return isCousins(root, x, y, 0, null);        
    }
    
    public boolean isCousins(TreeNode root, int x, int y, int depth, TreeNode parent)
    {
        if(root.val == x || root.val == y)
        {
            if(savedParent != null && savedParent != parent && level == depth)
            {
                return true;
            }    
            level = depth;
            savedParent = parent;
        }
        
        if(root.left != null && isCousins(root.left, x, y, depth + 1, root)) return true;
        
        if(root.right != null && isCousins(root.right, x, y, depth + 1, root)) return true;
        
        return false;      
    }         
}

//695. Max Area of Island
//https://leetcode.com/problems/max-area-of-island/

class areaOfIsland {
    public int maxAreaOfIsland(int[][] grid) {
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int maxArea = 0;
        
        for(int i = 0; i<rows; i++)
        {
            for(int j = 0; j<cols; j++)
            {
                if(grid[i][j] == 1)
                {
                    maxArea = Math.max(maxArea, markIslandBound(grid, i, j, rows, cols));
                }
            }
        }
        return maxArea;
    }
    
    int markIslandBound(int[][] grid, int i, int j, int rows, int cols)
    {
        if(i >= rows || i < 0 || j < 0 || j >= cols || grid[i][j] != 1) return 0;
        
        grid[i][j] = 0; //mark as visited by sinking it ,i.e., marking it 0
        
        int count = 1;
        
        //top
        count += markIslandBound(grid, i-1, j, rows, cols);        
        //right
        count += markIslandBound(grid, i, j+1, rows, cols);
        //down
        count += markIslandBound(grid, i+1, j, rows, cols);
        //left
        count += markIslandBound(grid, i, j-1, rows, cols);
        
        return count;
    }
}

//617. Merge Two Binary Trees
//https://leetcode.com/problems/merge-two-binary-trees/submissions/

class mergingTrees{
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        
        if(root1 == null) return root2;
        
        if(root2 == null) return root1;
        
        root1.val += root2.val;
        
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        
        return root1;        
    }
}

//70. Climbing Stairs
//https://leetcode.com/problems/climbing-stairs/submissions/

class stairWays{
    public int climbStairs(int n) {
        
        int[] dp = new int[n+1];
        
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2; i<=n; i++)
        {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}