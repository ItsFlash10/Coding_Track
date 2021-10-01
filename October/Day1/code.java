package Day1;

//Longest Common Subsequence Recursive method

class LCS{
    
    static int stringLength(String text1 , String text2, int m, int n)
    {
        if(m == 0 || n == 0) return 0;
        
        if(text1.charAt(m-1) == text2.charAt(n-1))
        {
            return 1 + stringLength(text1, text2, m-1, n-1);
        }
        else
        {
            return Math.max(stringLength(text1, text2, m-1, n), stringLength(text1, text2, m, n-1));
        }

    }
    static int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();

       return  stringLength(text1, text2, m, n);       
    }
}
