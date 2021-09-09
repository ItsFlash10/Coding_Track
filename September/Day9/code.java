package Day9;
// import java.util.*;

// 1. Find Missing And Repeating
//https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1#

class missingRepeating{
    int[] findTwoElement(int arr[], int n) {
        int[] map = new int[n+1];
        
        for(int i = 0; i<n; i++)
        {
            map[arr[i]]++;
        }
        
        int[] res = new int[2];
        for(int i = 1; i<map.length; i++)
        {
            if(map[i] == 2)
            {
                res[0] = i;
            }
            
            if(map[i] == 0)
            {
                res[1] = i;
            }
        }
        return res;
    }
}

//2. Frequencies of Limited Range Array Elements
//https://practice.geeksforgeeks.org/problems/frequency-of-array-elements-1587115620/1/?track=md-arrays&batchId=144#

class Solution{
    //Function to count the frequency of all elements from 1 to N in the array.
    public static void frequencyCount(int arr[], int N, int P)
    {
        int maxi = Math.max(P,N);
        int[] map = new int[maxi+1];
        
        for(int i=0; i<N; i++)
        {
            map[arr[i]]++;
        }
        
        for(int i=0; i<N; i++)
        {
            arr[i] = map[i+1];
        }
    }
}

//3. Jump Game
//https://practice.geeksforgeeks.org/problems/jump-game/0/?track=md-arrays&batchId=144

class jumpGame{
    static int canReach(int[] A, int N) {
        
        int reachable = 0;
        
        for(int i =0; i<N; i++)
        {
            if(reachable < i)
            {
                return 0;
            }
            
            reachable = Math.max(reachable, i+A[i]);
        }
        return 1;
        
    }
}
