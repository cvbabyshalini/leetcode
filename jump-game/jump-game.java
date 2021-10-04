class Solution {
    public boolean canJump(int[] nums) {
        boolean[] dp = new boolean[nums.length];
        dp[nums.length - 1] = true;
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            for(int jump = 1 ; jump <= nums[i] ; jump++){
                if(dp[i + jump] == true){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}