package Day5;

// Reverse words in a given string
//https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string5459/1/?track=md-string&batchId=144#

class revString 
{
    //Function to reverse words in a given string.
    String reverseWords(String S)
    {
        String ans = "";
        String[] str = S.split("\\.");
        
        for(int i = str.length-1; i>0; i--)
        {
            ans += str[i]+".";
        }
        
        return ans+str[0];
    }
}
