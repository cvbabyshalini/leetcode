class Solution {
    public int maxProduct(int[] nums) {
        int prod = 1;
        int res = Integer.MIN_VALUE;
        
        // left product
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == 0){
                res = Math.max(res, nums[i]);
                prod = 1;
            }
            else{
                prod *= nums[i];
                res = Math.max(res, prod);
            }
        }
        prod = 1;
        
        // right prod
        for(int i = nums.length - 1 ; i >= 0 ; i--){
            if(nums[i] == 0){
                res = Math.max(res, nums[i]);
                prod = 1;
            }
            else{
                prod *= nums[i];
                res = Math.max(res, prod);
            }
        }
        return res;
    }
}