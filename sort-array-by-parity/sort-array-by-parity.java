class Solution {
    public static void swap(int[] nums, int i , int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public int[] sortArrayByParity(int[] nums) {
        int i = 0 ; 
        int j = 0 ;
        while(i < nums.length){
            if(nums[i] % 2 == 0){
                swap(nums, i , j);
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return nums;
    }
}