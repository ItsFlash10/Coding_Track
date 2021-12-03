pacakge Day3;

//152. Maximum Product Subarray
//https://leetcode.com/problems/maximum-product-subarray/submissions/

public class mxSubArProd {
    public int maxProduct(int[] A) 
    {        
        if (A == null || A.length == 0) 
        {
            return 0;
        }
        
        int max = A[0];
        int min = A[0];
        int result = A[0];
        
        for (int i = 1; i < A.length; i++) 
        {
            int temp = max;
            max = Math.max(Math.max(max * A[i], min * A[i]), A[i]);
            min = Math.min(Math.min(temp * A[i], min * A[i]), A[i]);
            if (max > result) 
            {
                result = max;
            }
        }
        return result;
    }
}
