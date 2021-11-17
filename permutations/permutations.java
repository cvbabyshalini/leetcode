class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> l = new ArrayList<>();
        List<Integer> al = new ArrayList<>();
        helper(nums, 0, al, l);
        return l;
        
    }
    public static void helper(int[] nums, int count, List<Integer> al,List<List<Integer>> l){
        if(count == nums.length){
            l.add(new ArrayList<>(al));
            return;
        }
        for(int i = 0 ; i < nums.length ; i++){
            if(al.contains(nums[i]) == false){
                al.add(nums[i]);
                helper(nums, count + 1, al, l);
                al.remove(al.size() - 1);
            }
        }
    }
}