package Day20;

//268. Missing Number
//https://leetcode.com/problems/missing-number/

class missingNum {
    public int missingNumber(int[] nums) {
        
        int res = nums.length;
        
        for(int i = 0; i < nums.length; i++)
        {
            res = res ^ i;
            res = res ^ nums[i];
        }
        return res;        
    }
}

//151. Reverse Words in a String
//https://leetcode.com/problems/reverse-words-in-a-string/

class revWords{
    public String reverseWords(String s) {
        
        int i = s.length()-1;
        String ans = "";
        
        while(i >= 0)
        {
            while(i >= 0 && s.charAt(i) == ' ') i--;
            
            int j = i;
            
            if(i < 0) break;
            
            while(i >= 0 && s.charAt(i) != ' ') i--;
            
            if(!ans.isEmpty())
            {
                // since j is excluded in substring fxn 
               ans = ans.concat(" " + s.substring(i+1, j+1)); 
            }
            else
            {
               ans = ans.concat(s.substring(i+1, j+1));                
            }
        }
        return ans;
        
           //Using StringBuilder
//         String[] str = s.split(" ");
//         StringBuilder sb = new StringBuilder();
//         int end = str.length - 1;
        
//         for(int i = 0; i<= end; i++)
//         {
//             if(!str[i].isEmpty()) 
//             {
//                 sb.insert(0, str[i]);
//                 if(i < end) sb.insert(0, " ");
//             }
//         }        
//         return sb.toString();
    }
}
