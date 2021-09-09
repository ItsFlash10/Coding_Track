package Day9;

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