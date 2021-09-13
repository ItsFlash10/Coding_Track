package Day14;
import java.util.*;

// Find all pairs with a given sum
//https://practice.geeksforgeeks.org/problems/find-all-pairs-whose-sum-is-x5808/0/?track=md-hashing&batchId=144#


class pair  {  
    long first, second;  
    public pair(long first, long second)  
    {  
        this.first = first;  
        this.second = second;  
    }  
}


class pairGivenSum{
    public pair[] allPairs( long A[], long B[], long N, long M, long X) {
        
        HashSet<Long> map = new HashSet<>();
        
        for(int i = 0; i<N; i++)
        {
            map.add(A[i]);
        }
        
        Queue<pair> ans = new LinkedList<>();
        
        Arrays.sort(B);
        for(int i = 0; i<M; i++)
        {
            long target = X-B[i];
            if(map.contains(target))
            {
                pair P = new pair(target, B[i]);
                ans.add(P);
            }
        }
        pair[] res = new pair[(int)ans.size()];
        int j=ans.size()-1;
        while(ans.size()!=0)
        {
            res[j--] = ans.poll();
        }
        return res;
    }
}

