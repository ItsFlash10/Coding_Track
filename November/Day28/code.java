package Day28;
import java.util.*;

//797. All Paths From Source to Target
//https://leetcode.com/problems/all-paths-from-source-to-target/

class grpQuSolution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        List<List<Integer>> ans = new ArrayList<>();
        
        Queue<List<Integer>> q = new LinkedList<>();
        
        
        List<Integer> currList = new ArrayList<>();
        currList.add(0);
        
        q.add(currList);
        
        while(!q.isEmpty()) 
        {
            currList = q.poll();
             
            int v = currList.get(currList.size() - 1);
            if(v == graph.length - 1) 
            {
                ans.add(currList);
                continue;
            }
            
            for(int i : graph[v]) 
            {
                List<Integer> temp = new ArrayList<>(currList);
                temp.add(i);
                q.add(temp);
            }
        }
        return ans;
    }
}