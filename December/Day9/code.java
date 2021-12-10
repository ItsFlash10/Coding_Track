package Day9;
import java.util.*;

//1306. Jump Game III
//https://leetcode.com/problems/jump-game-iii/

class jumgameIII {
    public boolean canReach(int[] arr, int start) {
      Queue<Integer> q = new LinkedList<>();
      q.add(start);

      while(!q.isEmpty())
      {
          int idx = q.poll();
          if(arr[idx]==0)
              return true;

          int r = idx+arr[idx];
          int l = idx-arr[idx];
          arr[idx] = -1;     // make the visited index -1 
          if(r<arr.length && arr[r]!=-1)
              q.add(r);
          if(l>=0 && arr[l]!=-1)
              q.add(l);
      }
      return false;
    }
}
