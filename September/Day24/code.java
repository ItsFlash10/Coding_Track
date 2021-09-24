package Day24;

//Vaccine Day

//Find root using Searching algorithm
//https://practice.geeksforgeeks.org/problems/square-root/1/?track=md-searching&batchId=144#

class Solution
{
     long floorSqrt(long x)
	 {
		if(x == 0 || x == 1)
			return x;
			
		long start = 1, end = x, ans = 0;

		while(start <= end)
		{
			long mid = (start + end)/2;

			if(mid*mid == x)
				return mid;

			if(mid*mid < x)
			{
				start = mid+1;
				ans = mid;
			}
			else
				end = mid - 1;	
		}
		return ans;
	 }
}