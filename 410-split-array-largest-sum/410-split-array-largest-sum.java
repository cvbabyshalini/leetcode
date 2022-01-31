class Solution {
    public int splitArray(int[] nums, int m) {
        int sum = 0 ;
        int max = Integer.MIN_VALUE;
        for(int val : nums){
            sum += val;
            max = Math.max(val, max);
        }
        int lo = max;
        int hi = sum ;
        int ans = Integer.MAX_VALUE;
        while(lo <= hi){
            int mid = lo + (hi - lo) / 2;
            if(isMin(nums, mid) <= m){
                ans = mid;
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
        }
        return ans;
    }
    private static int isMin(int[] nums, int ans){
        int splits = 0;
        int sum = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(sum + nums[i] <= ans){
                sum += nums[i];
            }
            else{
                sum = nums[i];
                splits++;
            }
        }
        return splits + 1;
    }
}