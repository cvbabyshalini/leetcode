class Solution {
    public int maxProfit(int[] prices) {
        int[] leftmin = new int[prices.length];
        int[] rightmax = new int[prices.length];
        leftmin[0] = prices[0];
        for(int i = 1 ; i < prices.length ; i++){
            leftmin[i] = Math.min(leftmin[i - 1], prices[i]);
        }
        rightmax[prices.length - 1] = prices[prices.length - 1];
        for(int i = prices.length - 2 ; i >= 0 ; i--){
            rightmax[i] = Math.max(rightmax[i + 1], prices[i]);
        }
        int maxProfit = Integer.MIN_VALUE;
        for(int i = 0 ; i < prices.length ; i++){
            maxProfit = Math.max(rightmax[i] - leftmin[i] , maxProfit);
        }
        return maxProfit;
    }
}