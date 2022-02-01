class Solution {
    public int[] sortArray(int[] nums) {
        int[] res = mergesort(nums, 0, nums.length - 1);
        return res;
    }
    private static int[] mergesort(int[] nums, int l, int h){
        if(l == h){
            int[] bans = {nums[l]};
            return bans;
        }
        int mid = l + (h - l) / 2;
        int[] larr = mergesort(nums, l, mid);
        int[] rarr = mergesort(nums, mid + 1, h);
        int[] res = merge(larr, rarr);
        return res;
    }
    private static int[] merge(int[] a, int[] b){
        int res[] = new int[a.length + b.length];
        int i = 0 ; 
        int j = 0 ;
        int k = 0 ;
        while(i < a.length && j < b.length){
            if(a[i] < b[j]){
                res[k] = a[i];
                i++;
            }
            else{
                res[k] = b[j];
                j++;
            }
            k++;
        }
        while(i < a.length){
            res[k] = a[i];
            i++;
            k++;
        }
        while(j < b.length){
            res[k] = b[j];
            j++;
            k++;
        }
        return res;
    }
}