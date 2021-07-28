class Solution {
    public int maxSubArray(int[] nums) {
        int max_sum = Integer.MIN_VALUE;
        int current = 0;

        for (int i=0; i<nums.length; i++){

            current += nums[i];
            max_sum = Math.max(current,max_sum);

            if (current < 0){
                current = 0;
            }

        }
        return max_sum;
        
    }
}