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
