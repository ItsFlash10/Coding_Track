package Day15;
import java.util.*;

//Count distinct elements in every window
//https://practice.geeksforgeeks.org/problems/count-distinct-elements-in-every-window/1/?track=md-hashing&batchId=144#

class distinctCount
{
    ArrayList<Integer> countDistinct(int A[], int n, int k)
    {
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = 0; i<k; i++)
        {
            map.put(A[i],map.getOrDefault(A[i],0) + 1);
        }
        res.add(map.size());
        
        for(int i = k; i<n; i++)
        {
            if(map.get(A[i-k]) == 1)
            {
                map.remove(A[i-k]);
            }
            else
            {
                map.put(A[i-k], map.get(A[i-k])-1);
            }
            map.put(A[i], map.getOrDefault(A[i],0)+1);
            res.add(map.size());
        }
        return res;
    }
}
