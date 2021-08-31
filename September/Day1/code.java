package Day1;
import java.util.*;
//1. Maximize Number of 1's
// https://practice.geeksforgeeks.org/problems/maximize-number-of-1s0905/1/?track=md-arrays&batchId=144#

    class Solve {
        // m is maximum of number zeroes allowed to flip
        int findZeroes(int arr[], int n, int m) {
            
            int ans = 0;
            int j = -1;
            int count = 0;
            
            for(int i = 0; i < n; i++)
            {
                if(arr[i] == 0){
                    count++;
                }
                
                while(count>m)
                {
                    j++;
                    if(arr[j] == 0){
                        count--;
                    }
                }
                
                int length = i-j;
                if(length>ans){
                    ans = length;
                }
            } 
            return ans;
        }
    }


//2. Majority element
//https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1/?track=md-arrays&batchId=144#

    class Solution
    {
        static int majorityElement(int a[], int size)
        {
            int[] map = new int[a[size-1]+2];
            
            for(int i=0; i<size; i++)
            {
                map[a[i]]++;
            }
            
            for(int i=0; i<map.length; i++){
                if(map[i] > size/2){
                    return i;
                }
            }
            return -1;
        }
    }

//3. Plus One
// https://practice.geeksforgeeks.org/problems/plus-one/1/?track=md-arrays&batchId=144#

    class plusOne {
        static ArrayList<Integer> increment(ArrayList<Integer> arr , int N) {
            
            int idx = N-1;
            while(idx >= 0)
            {
                if(arr.get(idx) < 9)
                {
                    arr.set(idx, arr.get(idx)+1);
                    return arr;
                }
                else
                {
                    arr.set(idx, 0);
                }
                idx--;
            }
            arr.add(0, 1);
            return arr;    
        }
    }

//4. +ve -ve alternate
//https://practice.geeksforgeeks.org/problems/array-of-alternate-ve-and-ve-nos1401/1/?track=md-arrays&batchId=144#

    class posNeg{
        void rearrange(int arr[], int n) {
            ArrayList<Integer> pos = new ArrayList<>();
            ArrayList<Integer> neg = new ArrayList<>();
            
            for(int i = 0; i < n; i++)
            {
                if(arr[i] >= 0)
                {
                    pos.add(arr[i]);
                }
                
                else
                {
                    neg.add(arr[i]);
                }
            }
            
            int[] ans = new int[n];
            
            int i = 0;
            int j = 0;
            int k = 0;
            
            while(i < pos.size() && j < neg.size())
            {
                ans[k++] = pos.get(i++);
                ans[k] = neg.get(j);
                j++;
                k++;
            }
            
            while(i < pos.size())
            {
                ans[k++] = pos.get(i++);
            }
            
            while(j < neg.size())
            {
                ans[k++] = neg.get(j++);
            }
            
            for(int x = 0; x < n; x++)
            {
                arr[x] = ans[x];
            }
        }
    }

//5. Product array puzzle
//https://practice.geeksforgeeks.org/problems/product-array-puzzle4525/1/?track=md-arrays#

    class prodPuzzle 
    { 
        public static long[] productExceptSelf(int nums[], int n) 
        { 
            long[] prod_arr = new long[n];
            long prod = 1;
            int zeroFlag = 0;
            for(int i = 0; i<n; i++)
            {
                if(nums[i] != 0)
                {
                    prod = nums[i]*prod;
                }
                else
                {
                    zeroFlag += 1;
                }
            }
            
            if(zeroFlag > 1)
            {
                for(int i = 0; i<n; i++)
                {
                    prod_arr[i] = 0; 
                }
                return prod_arr;
                
            }
            if(zeroFlag == 1)
            {
                for(int i = 0; i<n; i++)
                {
                    if(nums[i] != 0)
                    {
                        prod_arr[i] = 0;
                    }
                    else
                    {
                        prod_arr[i] = prod;
                    }
                }
                return prod_arr;
                
            }
            
            for(int i = 0; i<n; i++)
            {
                prod_arr[i] = prod/nums[i]; 
            }
            return prod_arr;
        } 
    }