class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftprod = new int[nums.length];
        int[] rightprod = new int[nums.length];
        
        leftprod[0] = nums[0];
        for(int i = 1; i < nums.length; i++){
            leftprod[i] = leftprod[i-1] * nums[i];
        }
        
        rightprod[nums.length - 1] = nums[nums.length - 1];
        for(int i = nums.length - 2 ; i >= 0 ; i--){
            rightprod[i] = rightprod[i+1] * nums[i];
        }
        
        int[] ans = new int[nums.length];
        ans[0] = rightprod[1];
        ans[nums.length - 1] = leftprod[nums.length - 2];
        for(int i = 1 ; i < nums.length - 1 ; i++){
            ans[i] = leftprod[i-1] * rightprod[i+1];
        }
        return ans;
    }
}