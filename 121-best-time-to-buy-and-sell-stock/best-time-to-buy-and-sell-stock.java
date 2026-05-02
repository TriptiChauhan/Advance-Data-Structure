class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            int cost=prices[i]-min; // har bar min ko minus krenge ar usko update bhi krenge purani minimum value se like min=7, for next time min=1
            profit=Math.max(profit,cost);
            min=Math.min(min,prices[i]);
        }
        return profit;
    }
}