class Solution {
    public int maxProfit(int[] prices) {


        if(prices.length==1)
            return 0;
        
        int maxProfit = 0;
        int l=0, r=1;
        while (r < prices.length) {
            if(prices[l] < prices[r]) {
                int profit = prices[r] - prices[l];
                if(profit > maxProfit)
                    maxProfit = profit;
            } else {
                l = r;
            }
            r++;
        }

        return maxProfit;
    }
}
