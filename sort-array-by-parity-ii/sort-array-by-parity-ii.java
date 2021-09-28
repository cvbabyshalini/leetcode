class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int odd = 1;
        int even = 0;
        while(odd < nums.length && even < nums.length){
            while(even < nums.length && nums[even] % 2 == 0)
                even += 2;
            while(odd < nums.length && nums[odd] % 2 != 0)
                odd += 2;
            if(odd < nums.length && even < nums.length){
                int temp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = temp;
            }
        }
        return nums;
    }
}