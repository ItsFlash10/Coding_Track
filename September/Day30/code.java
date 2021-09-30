package Day30;

//Median of a 2D matrix using nested Binary Search
//https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1

class Solution {
    int countSmallerThanEqualToMid(int[] row, int mid)
    {
        int lo = 0;
        int hi = row.length-1;
        
        while(lo<=hi)
        {
            // int md = lo + (hi-lo)/2;
            int md = (lo + hi) >> 1;
            
            if(row[md] <= mid)
            {
                lo = md+1;
            }
            else
            {
                hi = md-1;
            }
        }
        return lo;
        
    }
    int median(int mat[][], int r, int c) {
        
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE;
        
        while(low<=high)
        {
            // int mid = low + (high-low)/2;
            int mid = (high+low) >> 1;
            int count = 0;
            
            for(int i = 0; i<r; i++)
            {
                count += countSmallerThanEqualToMid(mat[i],mid);
            }
            
            if(count<=(r*c)/2)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
            }
        }
        return low;
    }
}

//Boolean Matrix
//https://practice.geeksforgeeks.org/problems/boolean-matrix-problem-1587115620/1/?track=md-matrix&batchId=144#

class boolMat
{
    void booleanMatrix(int matrix[][])
    {
        boolean rowFlag = false;
        boolean colFlag = false;
        
        int r = matrix.length;
        int c = matrix[0].length;
        
        for(int row = 0; row<r; row++)
        {
            for(int col = 0; col<c; col++)
            {
                if(row == 0 && matrix[row][col] == 1 && rowFlag == false)
                {
                    rowFlag = true;
                }
                if(col == 0 && matrix[row][col] == 1 && colFlag == false)
                {
                    colFlag = true;
                }
                
                if(matrix[row][col] == 1)
                {
                    matrix[0][col] = 1;
                    matrix[row][0] = 1;
                }
            }
        }
        
        for(int row = 1; row<r; row++)
        {
            for(int col = 1; col<c; col++)
            {
                if(matrix[0][col] == 1 || matrix[row][0] == 1)
                {
                    matrix[row][col] = 1;
                }
            }
        }
        
        if(rowFlag == true)
        {
            for(int col = 0; col<c; col++)
            {
                matrix[0][col] = 1;
            }
        }
        if(colFlag == true)
        {
            for(int row = 0; row<r; row++)
            {
                matrix[row][0] = 1;
            }
        }
    }
}
    
//     //brute force
//     void booleanMatrix(int matrix[][])
//     {
//         int r = matrix.length;
//         int c = matrix[0].length;
        
//         int[][] temp = new int[r][c];
        
//         //created a matrix with all ele as 0
//         for(int row = 0; row<r; row++)
//         {
//             for(int col = 0; col<c; col++)
//             {
//                 temp[row][col] = 0;
//             }
//         }
        
//         //check in the original matrix if 1 is present pass it to fill function
//         for(int row = 0; row<r; row++)
//         {
//             for(int col = 0; col<c; col++)
//             {
//                 if(matrix[row][col] == 1)
//                 {
//                     fill(temp, row, col, r, c);
//                 }
//             }
//         }
//         //copying the temp matrix to the original
//         for(int row = 0; row<r; row++)
//         {
//             for(int col = 0; col<c; col++)
//             {
//                 matrix[row][col] = temp[row][col];
//             }
//         }
//     }
    
//     void fill(int[][] temp, int row, int col, int r, int c)
//     {
//         //fillin all the rows for that column
//         for(int i = 0; i<r; i++)
//         {
//             temp[i][col] = 1;
//         }
        
//         //fillin all the columns for that row
//         for(int i = 0; i<c; i++)
//         {
//             temp[row][i] = 1;
//         }
//     }
// }

//Rotate by 90 degree
//https://practice.geeksforgeeks.org/problems/rotate-by-90-degree0356/0/?track=md-matrix&batchId=144

class GFG
{
    static void rotate(int matrix[][]) 
    {
        //transpose of a matrix => row becomes column
        for(int row = 0; row<matrix.length; row++)
        {
            //so that swap happened only once col = row
            //else every ele will we swapped twice and be back to original
            for(int col = row; col<matrix[0].length; col++)
            {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
            
        }
        
        //reverse the matrix as to swap first row to last row
        for(int i = 0; i<matrix.length; i++)
        {
            int topIdx = 0;
            int downIdx = matrix.length-1;
            
            while(topIdx < downIdx)
            {
                int temp = matrix[topIdx][i];
                matrix[topIdx][i] = matrix[downIdx][i];
                matrix[downIdx][i] = temp;
                
                topIdx++;
                downIdx--;
            }
        }
    }
}