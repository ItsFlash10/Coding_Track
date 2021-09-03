package Day3;
import java.util.*;

//1. Count the number of possible triangles
//https://practice.geeksforgeeks.org/problems/count-possible-triangles-1587115620/1/?track=md-sorting&batchId=144

class possibleTraiangles
{
    //Function to count the number of possible triangles.
    static int findNumberOfTriangles(int arr[], int n)
    {
        Arrays.sort(arr);
        int count = 0;
        
        for(int i = n-1; i>=0; i--)
        {
            int left = 0;
            int right = i-1;
            
            while(right>left)
            {
                if(arr[right] + arr[left] > arr[i])
                {
                    count += right - left;
                    right--;
                }
                
                else
                {
                    left++;
                }
                
            }
            
        }
        return count;
    }
}
