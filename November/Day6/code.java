package Day6;

//260. Single Number III
//https://leetcode.com/problems/single-number-iii/

class mapMeth {
    public int[] singleNumber(int[] nums) {
        
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        int idx = 0;
        
        for(int ele : nums)
        {
            map.put(ele, map.getOrDefault(ele, 0)+1);
        }
        
        for(int ele : nums)
        {
            if(map.get(ele) == 1)
            {
                res[idx++] = ele;
            }
        }
        return res; 
    }
}
