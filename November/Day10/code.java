package Day10;

//122. Best Time to Buy and Sell Stock II
//https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

class stockBuySell {
    public int maxProfit(int[] prices) {
      
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int totalProfit = 0;
        for (int i = 1; i < prices.length; i++) 
        {            
            if (prices[i - 1] < prices[i]) 
            {
                totalProfit += prices[i] - prices[i - 1];
            }
        }

        return totalProfit;
    }
}
