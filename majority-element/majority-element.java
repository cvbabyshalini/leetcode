class Solution {
    public int majorityElement(int[] nums) {
        int val = nums[0];
        int count = 1;
        int i = 1;
        while(i < nums.length){
            if(nums[i] == val)
                count++;
            else{
                if(count > 0){
                    count--;
                }
                else{
                    val = nums[i];
                    count = 1;
                }
            }
            i++;
        }
        return val;
    }
}