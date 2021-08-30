package Day1;

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


