package Day1;

//Longest Common Subsequence Recursive method

class LCS{
    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length();
        int n = text2.length();
        
        if(m == 0 || n == 0) return 0;
        
        if(text1.charAt(m-1) == text2.charAt(n-1))
        {
            String t1 = text1.substring(0, m-1);
            String t2 = text2.substring(0, n-1);
            return 1 + longestCommonSubsequence(t1, t2);
        }
        else
        {
            String t1 = text1.substring(0, m-1);
            String t2 = text2.substring(0, n-1);
            
            return Math.max(longestCommonSubsequence(t1, text2), longestCommonSubsequence(text1, t2));
        }
    }
}
