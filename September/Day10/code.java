package Day10;

//1. Find the next prime
// https://practice.geeksforgeeks.org/problems/next-prime-number/1#
class nextPrimeNo{

    public static int nextPrime(int n)
    {
        
        int num = n + 1;
        
        while(n<Integer.MAX_VALUE)
        {
            int count = 0;
            for(int div = 2; div*div <= num; div++)
            {
                if(num%div == 0)
                {
                    count++;
                }
            }
            if(count == 0)
            {
                return num;
            }
            else
            {
                num++;
                continue;
            }
        }
        return 0;
        
        
    }
}