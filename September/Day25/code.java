package Day25;
import java.util.*;


//Wipro test(Rishav's Question)
class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
	{
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++)
		{
			arr[i] = scn.nextInt();
		}
		
		System.out.print("Answer:"+getSol(arr));
        scn.close();
	}
	
	static int getSol(int arr[])
	{
		int res = 0;
		int minFreq = Integer.MAX_VALUE;
		int maxFreq = 0;
		int flag = 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i<arr.length; i++)
		{
			map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
		}
		
		for(Map.Entry<Integer,Integer> entryEle : map.entrySet())
		{
			if((int)entryEle.getValue() < minFreq)
			{
				minFreq = (int)entryEle.getValue();
			}
			
			if((int)entryEle.getValue() > maxFreq)
			{
				maxFreq = (int)entryEle.getValue();
				flag += 1;
			}
		}
		
		if(flag == 1)
		{
			return 0;
		}
		if(map.get(maxFreq) >= map.get(minFreq))
		{
			res = maxFreq-minFreq;
		}
		return res;
		
	}
}
