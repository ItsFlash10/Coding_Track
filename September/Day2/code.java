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
//Same as above but with O(log (N)) complexity as we use binary search.
    class occurenceBS{
        
        public pair indexes(long v[], long x)
        {

            int low = 0;
            int high = v.length-1;
            int first_occ = -1;
            
            while(low<=high)
            {
                int mid = low + (high-low)/2;
                
                if(v[mid] < x)
                {
                    low = mid + 1;
                }
                
                else if(v[mid] > x)
                {
                    high = mid - 1;
                }
                
                else
                {
                    first_occ = mid;
                    high = mid - 1;
                }
            }
            
            low = 0;
            high = v.length-1;
            int last_occ = -1;
            
            while(low<=high)
            {
                int mid = low + (high-low)/2;
                
                if(v[mid] < x)
                {
                    low = mid + 1;
                }
                
                else if(v[mid] > x)
                {
                    high = mid - 1;
                }
                
                else
                {
                    last_occ = mid;
                    low = mid + 1;
                }
            }
            
            return new pair(first_occ, last_occ);
        }
    }



