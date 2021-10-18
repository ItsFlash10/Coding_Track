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
