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
