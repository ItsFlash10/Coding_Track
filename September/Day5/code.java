package Day5;
import java.util.*;

//1. Reverse words in a given string
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

// 2. Roman Number to Integer 
// https://practice.geeksforgeeks.org/problems/roman-number-to-integer3201/1/?track=md-string&batchId=144#

class romanToInt{
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String str) {
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        
        int size = str.length();
        int sum = 0;
        
        for(int i = size - 1; i>=0; i--)
        {
            if(str.charAt(i)=='V' || str.charAt(i) == 'X')
            {
                if(i > 0 && str.charAt(i-1) == 'I')
                {
                    sum -= 2;
                }
            }
            
            if(str.charAt(i)=='L' || str.charAt(i) == 'C')
            {
                if(i > 0 && str.charAt(i-1) == 'X')
                {
                    sum -= 20;
                }
            }
            
            if(str.charAt(i)=='D' || str.charAt(i) == 'M')
            {
                if(i > 0 && str.charAt(i-1) == 'C')
                {
                    sum -= 200;
                }
            }
            
            sum += map.get(str.charAt(i));
        }
        return sum;
        

    }
}
