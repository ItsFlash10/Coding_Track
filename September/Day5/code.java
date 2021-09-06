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
        
        for(int i = size - 1; i>=0; i--) //we can run the loop from as well
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


// Sum of consicutive subarray in a given range

class sumConSubArray
{

    static int countSub(int arr[], int n, int x)
    {

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (end < n)
        {
     
            sum += arr[end];

            while (start <= end && sum > x)
            {
                sum -= arr[start];
                start++;
            }

            count += (end - start + 1);
            end++;
        }
     
        return count;
    }

    static int findSubSumBtoC(int A[], int N,
                              int B, int C)
    {
     
        int right_count = countSub(A, N, C);

        int left_count = countSub(A, N, B - 1);
     
        return right_count - left_count;
    }

    public static void main (String[] args)
    {
        
        Scanner scn = new Scanner(System.in);
        int N = scn.nextInt();
        int B = scn.nextInt();
        int C = scn.nextInt();
        
        int[] A = new int[N];

        for(int i =0; i<N; i++)
        {
            A[i] = scn.nextInt();
        }
     
        System.out.println(findSubSumBtoC(A, N, B, C));

        scn.close(); //scn must be closed in order prevent resource leakage
    }
}
