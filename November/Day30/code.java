package Day30;
import java.util.*;

//85. Maximal Rectangle
//https://leetcode.com/problems/maximal-rectangle/

class dpQueSol {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        
        int m = matrix.length, n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;

        for (int i = 0; i < m; i++) 
        {
            for (int j = 0; j < n; j++) 
            {
                if (matrix[i][j] == '0')
                    heights[j] = 0;
                if (matrix[i][j] == '1')
                    heights[j] += 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }

    private int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        int maxArea = 0;

        for (int i = 0; i < heights.length; i++) 
        {
            int[] block = new int[]{i, heights[i]};
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]) 
            {
                block = stack.pop();
                maxArea = Math.max(maxArea, block[1] * (i - block[0]));
                block[1] = heights[i];
            }
            stack.push(block);
        }
        while (!stack.isEmpty()) 
        {
            int[] block = stack.pop();
            maxArea = Math.max(maxArea, block[1] * (heights.length - block[0]));
        }
        return maxArea;
    }
}
