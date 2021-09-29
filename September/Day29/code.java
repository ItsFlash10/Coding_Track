/* package whatever; // don't place package name! */
package Day29;
import java.util.*;

//Pepcoding contest solution
class code
{
	public static void main (String[] args) throws java.lang.Exception
	{
		int[] arr = {0,1,0,1,0,1};
		System.out.print(xyz(arr));
	}
	static int getSum(int[] arr, int n)
	{
		int bits[] = new int[25];
        int maxBit = 0, sum = 0, res = 0;

        for (int i = 0; i < n; i++) {
            int e = arr[i], cnt = 0;
            while (e > 0) {
                int rem = e % 2;
                e = e / 2;
                if (rem == 1) {
                    bits[cnt] += rem;
                }
                cnt++;
            }
            maxBit = Math.max(maxBit, cnt);
        }

        for (int i = 0; i < maxBit; i++) {
            int temp = (int)Math.pow(2, i);
            if (bits[i] > n / 2)
                res = res + temp;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = arr[i] ^ res;
            sum = sum + arr[i];
        }
        return sum;
	}


    //Question on whatsapp
    static int MOD = (int)1e9 + 7;
    static int xyz(int arr[])
    {
        ArrayList<Integer> position = new ArrayList<>();

        int count = 0;
        int len = arr.length;

        for (int i = 0; i < len; i++)
        {
            if (arr[i] == 1)
            {
                position.add(i - count);
                count++;
            }
        }

        if (count == len || count == 0)
            return 0;

        int medIdx = (count - 1) / 2;
        int medVal = position.get(medIdx);
        int ans = 0;

        for (int i = 0; i < position.size(); i++)
        {
            ans = (ans % MOD + Math.abs(position.get(i) - medVal) % MOD) % MOD;
        }
        return ans % MOD;
    }
}