package Day24;
import java.util.*;

//986. Interval List Intersections
//https://leetcode.com/problems/interval-list-intersections/

class intSecList {
		public int[][] intervalIntersection(int[][] A, int[][] B) {
      
			int i=0;
			int j=0;
			List<int[] > list=new ArrayList<>();
      
			while(i<A.length && j<B.length)
      {
				int lower=Math.max(A[i][0],B[j][0]);
				int upper=Math.min(A[i][1],B[j][1]);
				if(lower<=upper)
        {
					list.add(new int[]{lower,upper});
				}
				if(A[i][1]<B[j][1])
        {
					i++;
				}
        else
        {
					j++;
				}
			}
			return list.toArray(new int[list.size()][]);
		}
	}
