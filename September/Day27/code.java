package Day27;
import java.util.*;

class wiproSol
{
    public static Scanner scn = new Scanner(System.in);
    public static void main (String[] args) throws java.lang.Exception
	{
		String[] arr = new String[3];
		
		for(int i = 0; i<3; i++)
		{
			arr[i] = scn.next();
		}
		System.out.print(sol(arr));
	}
	
	static int sol(String[] arr)
	{
		int res = 0;
		int o = Integer.MIN_VALUE;
		int t = Integer.MAX_VALUE;
		int h = Integer.MIN_VALUE;
		int th = Integer.MAX_VALUE;
		
		for(int i = 0; i<arr.length; i++)
		{
			String ch = arr[i];

			o = Math.max(ch.charAt(3)-'0',o);       //alternate methods are listed(doe the one used, is the best):
			t = Math.min(ch.charAt(2)-'0',t);       //Integer.parseInt(String.valueOf(ch.charAt(2)))
			h = Math.max(ch.charAt(1)-'0',h);       //Character.getNumericValue(ch.charAt(1))
			th = Math.min(ch.charAt(0)-'0',th);
		}
		res = o+(t*10)+(h*100)+(th*1000);
		return res;
	}
}