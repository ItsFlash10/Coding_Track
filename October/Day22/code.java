package Day22;
import java.util.*;

//451. Sort Characters By Frequency
//https://leetcode.com/problems/sort-characters-by-frequency/

class introHeap {
    public String frequencySort(String s) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        
        for(int i = 0; i<n; i++)
        {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch,0)+1);
        }
        
        //sort on based on the freq of the char in the heap
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a,b) -> map.get(b)- map.get(a));
        
        maxHeap.addAll(map.keySet()); //add all entries of the map to a Heap
        
        StringBuilder res = new StringBuilder();
        
        while(!maxHeap.isEmpty()) //till the heap is not empty iterate for result
        {
            char current = maxHeap.remove();
            for(int i = 0; i<map.get(current); i++) //loop till the freq of the char and add to the result
            {
                res.append(current);                
            }
        }
        return res.toString();                
    }
}

//1636. Sort Array by Increasing Frequency
//https://leetcode.com/problems/sort-array-by-increasing-frequency/

class freqSort {
    public int[] frequencySort(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int num : nums)
        {
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        
        List<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a, b) -> {
            //this is bascially if freq are equal then compare the key
            //else if not equal than compare the val and sort accordingly
            return (map.get(a) == map.get(b))? b - a : map.get(a) - map.get(b);
        });
        
        int res[] = new int[nums.length];
        int idx = 0;
        
        for(int num : list)
        {
            for (int j = 0; j < map.get(num); j++) {
                res[idx++] = num;
            }
        }
        return res;     
    }
}

//119. Pascal's Triangle II
//https://leetcode.com/problems/pascals-triangle-ii/

class rowPascal{
    public List<Integer> getRow(int rowIndex) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        
        for(int i = 0; i<=rowIndex; i++)
        {
            res.add(nCr(rowIndex,i));
        }
        return res;
    }
    
    int nCr(int n, int r)
    {
        long res = 1;
        r = Math.min(r, n-r);
        
        for(int i = 1; i<=r; i++)
        {
            res = (res*(n-i+1))/i;
        }
        return (int)res;
    }
}

//905. Sort Array By Parity
//https://leetcode.com/problems/sort-array-by-parity/

class paritySort {
    public int[] sortArrayByParity(int[] nums) {

        int left = 0;
        
        for(int i = 0; i<nums.length; i++)
        {
            if((nums[i]%2) == 0)
            {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left++] = temp;
            }
        }
        return nums;        
    }
}

//27. Remove Element
//https://leetcode.com/problems/remove-element/

class eleRemoval {
    public int removeElement(int[] nums, int val) {
        
        int j = 0;
        
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] != val)
            {
                nums[j++] = nums[i];                
            }
        }
        return j;
    }
}