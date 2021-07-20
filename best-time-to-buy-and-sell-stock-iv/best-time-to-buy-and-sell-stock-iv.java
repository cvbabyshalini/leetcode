class Solution {
    public int maxProfit(int k, int[] prices) {
        int[][] dp = new int[k+1][prices.length];
        if(prices.length == 0 ){
            return 0;
        }
        
            for(int i = 1 ; i < dp.length ; i++){
            int max = 0-prices[0];
            for(int j = 1 ; j < dp[0].length ; j++){
                dp[i][j] = Math.max(dp[i][j-1] , max + prices[j]);
                max = Math.max(max , dp[i-1][j] - prices[j]);
            }
            }
        
        return dp[dp.length-1][dp[0].length-1];
            
    }
}