package Day18;
import java.util.*;

//448. Find All Numbers Disappeared in an Array
//https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/

class disArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        
        int[] counter = new int[nums.length + 1];
        
        for(int i = 0; i<nums.length; i++)
        {
            counter[nums[i]]++;
        }
        
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 1; i<counter.length; i++)
        {
            if(counter[i] == 0)
            {
                res.add(i);
            }
        }
        
        return res;
    }
}