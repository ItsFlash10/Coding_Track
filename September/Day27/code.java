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

//Wipro Solution
class Solution
{
	public static Scanner scn= new Scanner(System.in);
	public static void main(String[] args) {
		int n = scn.nextInt();

		System.out.println(decode(n));
	}
	static int decode(int n)
	{
		int sum = 0;
		if(armStCheck(n) == true)
		{
			while(n > 0)
			{
				int digit = n%10;
				if((digit%2) == 0)
				{
					sum += digit;
				}
				n = n/10;
			}
		}
		else
		{
			while(n > 0)
			{
				int digit = n%10;
				if((digit%2) != 0)
				{
					sum += digit;
				}
				n = n/10;
			}
		}
		return sum;
	}
	
	static boolean armStCheck(int n)
	{
		int temp, digits=0, last=0, sum=0;   
		temp=n;   

		while(temp>0)    
		{   
			temp = temp/10;   
			digits++;   
		}

		temp = n; 

		while(temp>0)   
		{   
			last = temp % 10;
			sum +=  (Math.pow(last, digits));   
			temp = temp/10;   
		}  

		if(n==sum) return true;      
		else return false;   
	}

	//if question was to check it for fibonacii
	static boolean fibCheck(int n)
	{
		int firstTerm = 0;
        int secondTerm = 1;
        int thirdTerm = 0;
		
        while (thirdTerm < n)
        {
			thirdTerm = firstTerm + secondTerm;
            firstTerm = secondTerm;
            secondTerm = thirdTerm;
        }
		
        if(thirdTerm == n){
			return true;
		}
		return false;
	}
}

//Kadanes for ArrayList

class Sol
{ 
    public static int maxSubArray(ArrayList<Integer> array)
    {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;;
        
        for(int i = 0; i<array.size(); i++)
        {
            sum += array.get(i);
            maxSum = Math.max(maxSum,sum);
            
            if(sum < 0)
            {
                sum = 0;
            }
        }
        return maxSum;
    }
}

