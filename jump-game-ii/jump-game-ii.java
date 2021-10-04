class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[dp.length - 1] = 0;
        for (int i = nums.length - 2; i >= 0; i--){
            int min = Integer.MAX_VALUE - 1;
            if (nums[i] == 0)
                dp[i] = min;
            else {
                for(int jump = 1; (i + jump) < nums.length && jump <= nums[i]; jump++)
                    min = Math.min(min, dp[i + jump]);
                dp[i] = min + 1;
            }
        }
        return dp[0];
    }
}