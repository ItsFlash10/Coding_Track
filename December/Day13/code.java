package Day13;

//https://leetcode.com/problems/consecutive-characters/
//1446. Consecutive Characters


class mxPwr {
    public int maxPower(String s) {
        
        int len = s.length()-1;
        int res = 1;
        int count = 1;
        while(len != 0)
        {
            if(s.charAt(len) == s.charAt(len-1))
            {
                count++;
                res = Math.max(count, res);
            }
            
            else
            {
                count = 1;
            }
            len--;
        }
        return res;
    }
}
