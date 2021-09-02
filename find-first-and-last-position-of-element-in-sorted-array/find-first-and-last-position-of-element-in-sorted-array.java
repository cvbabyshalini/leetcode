class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = bs(nums, target);
        return res;
        
    }
    public static int[] bs(int[] nums, int target){
        int[] res = new int[2];
        int fi = -1;
        int left = 0;
        int right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                fi = mid;
                right = mid - 1;
            }
            else if(nums[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        int ri = -1;
        left = 0;
        right = nums.length - 1;
        while(left <= right){
            int mid = (left + right)/2;
            if(nums[mid] == target){
                ri = mid;
                left = mid + 1;
            }
            else if(target < nums[mid]){
                right = mid - 1;
            }
            else
                left = mid + 1;
        }
        res[0] = fi;
        res[1] = ri;
        return res;
    }
}