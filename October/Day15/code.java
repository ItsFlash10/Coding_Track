package Day15;

//No. of paths(Recursion)
//https://practice.geeksforgeeks.org/problems/number-of-paths0926/1/?track=md-recursion&batchId=144
class paths{
    
    long numberOfPaths(int m, int n) {
        if(m<=0 || n<=0) return 0;
        if(m==1 && n==1) return 1;
        return numberOfPaths(m-1, n)+numberOfPaths(m, n-1);
    }
}

//309. Best Time to Buy and Sell Stock with Cooldown
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

class stocksBuySell{
    public int maxProfit(int[] prices) {
        int dp[][] = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++)
            Arrays.fill(dp[i], -1);
        
        return maxProfit(prices, 0, 0, dp);
    }
    
    public int maxProfit(int[] prices, int day, int bought, int[][] dp) {
        if(day >= prices.length)
            return 0;
        
        if(dp[day][bought] != -1)
            return dp[day][bought];
        
        if(bought == 0) 
        {
            return dp[day][bought] = Math.max(maxProfit(prices, day + 1, 1, dp) - prices[day], maxProfit(prices, day + 1, bought, dp));
        }
        else
        {
            return dp[day][bought] = Math.max(prices[day] + maxProfit(prices, day + 2, 0, dp), maxProfit(prices, day + 1, bought, dp));
        }
    }
}
