package Day18;

//902. Numbers At Most N Given Digit Set
//https://leetcode.com/problems/numbers-at-most-n-given-digit-set/submissions/

class atmsstNDgtSt {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String N =  String.valueOf(n);
        int k =  N.length();
        int numsLen =digits.length;
        
        int count = 0;
        
		// all 1 to  k-1 digit number smaller than k digits number , can be made by using all digit 
        for(int i=1;i<k;i++){
            count += Math.pow(numsLen,i);
        }
        
        
        for(int i=0;i<k;i++){// iterate for digit in N
            int d =  N.charAt(i)-'0';
            boolean equal = false;
            for(int j=0;j < numsLen ;j++ ){
                if( Integer.valueOf(digits[j]) < d ){                     
                    count += Math.pow(numsLen,k-i-1);    

                }
                else if(Integer.valueOf(digits[j]) == d){
                    equal =  true;                    
                }
            }
            if(!equal){
                return count;
            }                       
        }
        
        return count+1;
           
    }
}
