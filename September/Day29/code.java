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