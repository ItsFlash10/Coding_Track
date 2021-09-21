package Day21;

import java.util.*;

//Array Pair Sum Divisibility Problem
//https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/0/?track=md-hashing&batchId=144#

class Solution {
    public boolean canPair(int[] nums, int k) {
        
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int ele : nums)
        {
            int rem = ele%k;
            map.put(rem, map.getOrDefault(rem, 0)+1);
        }
        
        for(int val : nums)
        {
            int rem = val % k; 
            //if rem is 0 then the freq of that value of rem must be even
            if(rem == 0)
            {
                if(map.get(rem) % 2 == 1)
                {
                    return false;
                }
            }
            
            //if rem is k/2 then the freq of that value of rem must be even as well
            //rem == k/2 odd ke liye kaam ni krega isliye waise likha hai
            else if(2*rem == k)
            {
                if(map.get(rem) % 2 == 1)
                {
                    return false;
                }
            }
            
            //if rem is x then there must exist k-x
            else
            {
                if(map.get(rem) != map.get(k-rem))
                {
                    return false;
                }
            }
        }
        return true;
    }
}


//Is Sudoku Valid
//https://practice.geeksforgeeks.org/problems/is-sudoku-valid4820/1/?track=md-hashing&batchId=144

class sudokuValid{
    static int isValid(int mat[][]){
        
        HashSet<String> set = new HashSet<>();
        for(int row = 0; row<9; row++)
        {
            for(int column = 0; column<9; column++)
            {
                if(mat[row][column] != 0)
                {
                    //put string of row+rowNumber+ele; same for column
                    if(!set.add("row"+row+mat[row][column]) || !set.add("column"+column+mat[row][column]))
                    {
                        return 0;
                    }
                    //put string of box+boxNumber+ele; box = (row/3)*3 + col/3
                    if(!set.add("box"+(row/3)*3 + column/3 + mat[row][column]))
                    {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
}

//Anagram
//https://practice.geeksforgeeks.org/problems/anagram-1587115620/1/?track=md-string&batchId=144

class anagram
{    
    //Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String a,String b)
    {
        
        HashMap<Character,Integer> map = new HashMap<>();
        
        for(int i = 0; i<a.length(); i++)
        {
            char ch = a.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        
        for(int i = 0; i<b.length(); i++)
        {
            char ch = b.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)-1);
        }
        for (Map.Entry mapElement : map.entrySet()) {
            if((int)mapElement.getValue()!= 0)
            {
                return false;
            }
        }
        return true;
        
    }
}