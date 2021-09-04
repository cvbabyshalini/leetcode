class Solution {
    public int dominantIndex(int[] nums) {
        int max = Integer.MIN_VALUE;
        int maxidx = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > max){
                max = nums[i];
                maxidx = i;
            }
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(max < nums[i] + nums[i] && maxidx != i){
                return -1;
            }
        }
        return maxidx;
    }
}