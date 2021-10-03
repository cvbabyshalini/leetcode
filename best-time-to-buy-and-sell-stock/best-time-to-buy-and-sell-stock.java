class Solution {
    public int maxProfit(int[] prices) {
        int maxsf = prices[prices.length-1];
        int maxP = 0;
        for(int i = prices.length-2; i>=0 ; i--){
            maxsf = Math.max(maxsf, prices[i]);
            maxP = Math.max(maxP,maxsf-prices[i]);
        }
        return maxP;
    }
}