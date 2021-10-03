package Day3;
import java.util.*;

//55. Jump Game(Daily Challenege)
//https://leetcode.com/problems/jump-game/

class jumpGame{
    public boolean canJump(int[] nums) {
        int maxReachable = nums[0];
        
        for(int i = 0; i<nums.length; i++)
        {
            if(maxReachable < i)
            {
                return false;
            }
            maxReachable = Math.max(maxReachable, i+nums[i]);
        }
        return true;
    }
}

//566. Reshape the Matrix
//https://leetcode.com/problems/reshape-the-matrix/

class reshapeMatrix{
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        
        int row = mat.length;
        int col = mat[0].length;
        
        if((row*col) != (r*c)) return mat;
 
        int res[][] = new int[r][c];
        int rowNum = 0;
        int colNum = 0;
     
        for(int i = 0; i < row; i++)
        {
            for(int j = 0; j < col; j++)
            {
                res[rowNum][colNum] = mat[i][j];
                colNum++;
                if(colNum == c)
                {
                    colNum = 0;
                    rowNum++;
                }
            }
        }
        return res; 
    }
}