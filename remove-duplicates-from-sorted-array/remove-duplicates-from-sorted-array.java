class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[i] != nums[j]){
                nums[count] = nums[j];
                count++;
                i = j;
                j++;
            }
            else{
                j++;
            }
        }
        return count;
        
    }
}