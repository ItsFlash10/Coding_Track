package Day24;
import java.util.*;

//56. Merge Intervals

class mrgitvrl {
    public int[][] merge(int[][] intervals) {
        
        List<int[]> res = new ArrayList<>();
        
        if(intervals.length == 0 || intervals == null)
        {
            return res.toArray(new int[0][]);
        }
        
        Arrays.sort(intervals,(a,b) -> a[0]-b[0]);
        
        for(int[] interval : intervals)
        {
            if(res.size() == 0)
            {
                res.add(interval);
            }
            else
            {
                int[] prevInterval = res.get(res.size()-1);
                
                if(interval[0] <= prevInterval[1])
                {
                    prevInterval[1] = Math.max(prevInterval[1], interval[1]);
                }
                else
                {
                    res.add(interval);
                }
            }
        }
        return res.toArray(new int[0][]);      
    }
}
