class Solution {
    public void rotate(int[] nums, int k) {
        if(k > nums.length){
            k = k % nums.length;
        }
        reverse(nums, 0, nums.length-k-1);
        reverse(nums, nums.length-k, nums.length-1);
        reverse(nums, 0, nums.length-1);
        
    }
    public static void reverse(int[] nums, int i, int j){
        int left = i;
        int right = j;
        while(left < right){
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
}