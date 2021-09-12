class Solution {
    public int firstMissingPositive(int[] nums) {
        // find occurence of 1 and mark the elements that are out of range 
        int n = nums.length;
        boolean one = false;
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == 1) one = true;
            if(nums[i] < 1 || nums[i] > n) nums[i] = 1;
        }
        if(one == false) return 1;
        
        // mark elements in the array
        for(int i = 0 ; i < n ; i++){
            int idx = Math.abs(nums[i]) - 1;
            nums[idx] = -Math.abs(nums[idx]);
        }
        
        // check first positive number
        for(int i = 0 ; i < n ; i++){
            if(nums[i] > 0)
                return i + 1;
        }
        return n + 1;
    }
}