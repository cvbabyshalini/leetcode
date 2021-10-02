class Solution {
    public int searchInsert(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;
        int pivot=0;
        
        while(i<j){
            pivot = (i+j)/2;
            if(nums[pivot]>target)
                j=pivot-1;
            else if(nums[pivot]<target)
                i=pivot+1;
            else
                return pivot;
        }

        int index = 0;
        for (i = 0; i< nums.length; i++){
            if (target > nums[nums.length - 1]) index = nums.length;
            if (target < nums[0]) index = 0;
            if (i > 0){
                if (nums[i-1] < target && nums[i] >= target) index = i;
            }
        }
        return index;
    }
}