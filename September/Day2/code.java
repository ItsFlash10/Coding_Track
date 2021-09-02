package Day2;
import java.util.*;

//1. Left most and right most index 
//https://practice.geeksforgeeks.org/problems/find-first-and-last-occurrence-of-x0849/0/?track=md-searching#

    class pair  {  
        long first, second;  
        public pair(long first, long second)  
        {  
            this.first = first;  
            this.second = second;  
        }  
    }

//This is O(N), we can do this it in log(N) using binary search    
    class occurence{
        
        public pair indexes(long v[], long x)
        {
            
            long first_occ = -1;
            long last_occ = -1;
            
            for(int i = 0; i < v.length; i++)
            {
                if(v[i] == x)
                {
                    first_occ = i;
                    break;
                }
            }
            
            for(int i = v.length-1; i >= 0; i--)
            {
                if(v[i] == x)
                {
                    last_occ = i;
                    break;
                }
            }
            
            return new pair(first_occ, last_occ);
        }
    }



