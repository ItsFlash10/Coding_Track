/* package whatever; // don't place package name! */
package Day29;
import java.util.*;

//Pepcoding contest solution
class code
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = {0,1,0,1,0,1};
		System.out.print(xyz(arr));
	}
	static int getSum(int[] arr, int n)
	{
		int bits[] = new int[25];
        int maxBit = 0, sum = 0, res = 0;

        for (int i = 0; i < n; i++) {
            int e = arr[i], cnt = 0;
            while (e > 0) {
                int rem = e % 2;
                e = e / 2;
                if (rem == 1) {
                    bits[cnt] += rem;
                }
                cnt++;
            }
            maxBit = Math.max(maxBit, cnt);
        }

        for (int i = 0; i < maxBit; i++) {
            int temp = (int)Math.pow(2, i);
            if (bits[i] > n / 2)
                res = res + temp;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] ^ res;
            sum = sum + arr[i];
        }
        return sum;
	}


    //Question on whatsapp
    static int MOD = (int)1e9 + 7;
    static int xyz(int arr[])
    {
        ArrayList<Integer> position = new ArrayList<>();

        int count = 0;
        int len = arr.length;

        for (int i = 0; i < len; i++)
        {
            if (arr[i] == 1)
            {
                position.add(i - count);
                count++;
            }
        }

        if (count == len || count == 0)
            return 0;

        int medIdx = (count - 1) / 2;
        int medVal = position.get(medIdx);
        int ans = 0;

        for (int i = 0; i < position.size(); i++)
        {
            ans = (ans % MOD + Math.abs(position.get(i) - medVal) % MOD) % MOD;
        }
        return ans % MOD;
    }
}

//Print matrix in diagonal pattern
//https://practice.geeksforgeeks.org/problems/print-matrix-in-diagonal-pattern/1/?difficulty[]=0&page=1&sortBy=accuracy&category[]=Matrix&query=difficulty[]0page1sortByaccuracycategory[]Matrix#

class Solution {
    public int[] matrixDiagonally(int[][] mat) {
        
        if(mat.length == 0 || mat[0].length == 0) return new int[0];
        
        int m = mat.length;
        int n = mat[0].length;
        int i = 0;
        int[] res = new int[m*n];
        int row = 0;
        int col = 0;
        boolean up = true;
        
        while(row<m && col<n)
        {
            //digonal down to up
            if(up)
            {
                while(row>0 && col<n-1)
                {
                    res[i++] = mat[row][col];
                    row--;
                    col++;
                }
                res[i++] = mat[row][col];
                if(col == n-1) row++;
                else col++;
                
            }
            //diagonal up to down
            else
            {
                while(col>0 && row<m-1)
                {
                    res[i++] = mat[row][col];
                    row++;
                    col--;
                }
                res[i++] = mat[row][col];
                if(row == m-1) col++;
                else row++;
            }
            up = !up;
        }
        return res;
    }
}

//Spirally traversing a matrix 
//https://practice.geeksforgeeks.org/problems/spirally-traversing-a-matrix-1587115621/1#

class traverseSpiralMatrix
{
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        int top = 0;
        int down = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        ArrayList<Integer> res = new ArrayList<>();
        int dir = 0;  //important as this will tell what to do
        
        while(top <= down && left <= right)
        {
            if(dir == 0) //traverse from left to right
            {
                for(int i = left; i<=right; i++)
                {
                    res.add(matrix[top][i]);
                }
                top++;
            }
        
            else if(dir == 1) //traverse from top to down
            {
                for(int i = top; i<=down; i++)
                {
                    res.add(matrix[i][right]);
                }
                right--;
            }
            
            else if(dir == 2) //traverse from right to left
            {
                for(int i = right; i>=left; i--)
                {
                    res.add(matrix[down][i]);
                }
                down--;
            }
            
            else if(dir == 3) //traverse from down to top
            {
                for(int i = down; i>=top; i--)
                {
                    res.add(matrix[i][left]);
                }
                left++;
            }
            dir = (dir+1)%4; //changing direction
        }
        return res;
    }
}

//74. Search a 2D Matrix
//https://leetcode.com/problems/search-a-2d-matrix/

class searchEleMat {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix.length == 0) return false;
        
        int low = 0;
        int N = matrix.length;
        int M = matrix[0].length;
        int high = (M*N) - 1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2; //to prevent overflow
            
            //row = mid/col length && col = mid%col length
            if(matrix[mid/M][mid%M] < target)
            {
                low = mid + 1;
            }
            else if(matrix[mid/M][mid%M] > target)
            {
                high = mid-1;
            }
            else
            {
                return true;
            }
        }
        return false;
    }
}

//Search in a matrix(GFG) //in this 1st ele is not greater than the last ele of previous row unlinke last Leetcode question
//https://practice.geeksforgeeks.org/problems/search-in-a-matrix17201720/1

class Sol
{
    public static int matSearch(int matrix[][], int N, int M, int x)
    {
        //put the pointer at top right as every ele to left will be smaller 
        //and every ele down to it will be greater
        int row = 0;
        int col = M-1;
        
        while(row<N && col>=0)
        {
            if(matrix[row][col] == x)
            {
                return 1;
            }
            if(matrix[row][col] > x)
            {
                col--;
            }
            else
            {
                row++;
            }
        }
        return 0;
    }
}

//NOTE: BINARY SEARCH can be used in any search space which is monotonic in nature 
//i.e., strictly increasing or decreasing

//Median in a row-wise sorted Matrix 
//https://practice.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1
class medianOfMat
{
    int median(int mat[][], int r, int c) 
    {
        
        int[] arr = new int[r*c];
        int k =0;
        for(int i=0;i<r;i++)
            for(int j=0;j<c;j++)
            {
                arr[k] = mat[i][j];
                k++;
            }
        Arrays.sort(arr);
        return arr[r*c/2];

    }
}

//optimised for Median in a row-wise sorted matrix
class optiSol {
    private int countSmallerThanMid(ArrayList<Integer> row, int mid) {
        int l = 0, h = row.size() - 1; 
        while(l <= h) {
            int md = (l + h) >> 1; 
            if(row.get(md) <= mid) {
                l = md + 1;
            }
            else {
                h = md - 1;
            }
        }
        return l; 
    }
    public int findMedian(ArrayList<ArrayList<Integer>> A) {
        int low = Integer.MIN_VALUE;
        int high = Integer.MAX_VALUE; 
        int n = A.size();
        int m = A.get(0).size(); 
        while(low <= high) {
            int mid = (low + high) >> 1; 
            int cnt = 0;
            for(int i = 0;i<n;i++) {
                cnt += countSmallerThanMid(A.get(i), mid); 
            }
    
            if(cnt <= (n * m) / 2) low = mid + 1; 
            else high = mid - 1; 
        }
        return low; 
    }
}