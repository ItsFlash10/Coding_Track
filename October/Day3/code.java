package Day3;
import java.util.*;

//55. Jump Game(Daily Challenege)
//https://leetcode.com/problems/jump-game/

class jumpGame{
    public boolean canJump(int[] nums) {
        int maxReachable = nums[0];
        
        for(int i = 0; i<nums.length; i++)
        {
            if(maxReachable < i)
            {
                return false;
            }
            maxReachable = Math.max(maxReachable, i+nums[i]);
        }
        return true;
    }
}