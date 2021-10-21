package Day21;
import java.util.*;

//11. Container With Most Water
//https://leetcode.com/problems/container-with-most-water/

class maxAreaContainer {
    public int maxArea(int[] height) {
        
        int len = height.length;
        int right = len - 1;
        int left = 0;
        int res = 0;
        
        while(left < right)
        {
            if(height[left] < height[right])
            {
                res = Math.max(res, height[left] * (right - left));
                left++;                
            }
            else
            {
                res = Math.max(res, height[right] * (right - left));                
                right--;
            }
        }
        return res;        
    }
}

//380. Insert Delete GetRandom O(1)
//https://leetcode.com/problems/insert-delete-getrandom-o1/submissions/

class RandomizedSet 
{
	// map contains value with it's index
	Map<Integer, Integer> map;
	// contains values
	List<Integer> list;

	public RandomizedSet() 
    {
		map = new HashMap<>();
		list = new ArrayList<>();
	}

	public boolean insert(int val) 
    {
		if (map.containsKey(val)) return false;

		list.add(val);
		// keep track of index in array
		map.put(val, list.size() - 1);

		return true;
	}

	public boolean remove(int val) 
    {
		if (!map.containsKey(val)) return false;

		// set the index of val with last element
		list.set(map.get(val), list.get(list.size() - 1));
		// update index in map
		map.put(list.get(list.size() - 1), map.get(val));

		map.remove(val);
		// O(1) remove
		list.remove(list.size() - 1);

		return true;
	}

	public int getRandom() 
    {
		// [0, size - 1]
		return list.get((int)(Math.random() * list.size()));
	}
}