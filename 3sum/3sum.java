class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(i!=0 && nums[i] == nums[i-1]){
                continue;
            }
            int val1 = nums[i];
            int smallTarget = -1 * val1;
            List<List<Integer>> l = twoSum(nums, i + 1, nums.length - 1 , smallTarget);
            for(List<Integer> list : l){
                list.add(val1);
                res.add(list);
            }
        }
        return res;
    }
    public static List<List<Integer>> twoSum(int[] nums, int st, int end, int target){
        List<List<Integer>> list = new ArrayList<>();
        int left = st;
        int right = end;
        while(left < right){
            if(left!= st && nums[left] == nums[left-1]){
                left++;
                continue;
            }
            int sum = nums[left] + nums[right];
            if(sum == target){
                List<Integer> l = new ArrayList<>();
                l.add(nums[left]);
                l.add(nums[right]);
                list.add(l);
                left++;
                right--;
            }
            else if(sum > target){
                right--;
            }
            else{
                left++;
            }
        }
        return list;
    }
}