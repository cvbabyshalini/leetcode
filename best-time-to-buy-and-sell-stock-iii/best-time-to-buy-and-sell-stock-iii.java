class Solution {
    public int maxProfit(int[] prices) {
        int[] left = new int[prices.length];
        int[] right = new int[prices.length];
        int minsf = prices[0];
        left[0] = 0;
        for(int i = 1 ; i < left.length; i++){
            minsf = Math.min(minsf,prices[i]);
            left[i] = Math.max(left[i-1], prices[i]-minsf);
        }
        int maxsf = prices[prices.length-1];
        right[prices.length-1] = 0;
        for(int i = right.length-2 ; i>=0 ; i--){
            maxsf = Math.max(maxsf, prices[i]);
            right[i] = Math.max(right[i+1],maxsf-prices[i]);
        }
        int maxP = 0;
        for(int i = 0 ; i < prices.length ; i++){
            maxP = Math.max(maxP,left[i]+right[i]);
        }
        return maxP;
        
    }
}