class Solution {
    public void wiggleSort(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        // for odd index
        int j = arr.length-1;
        int i = 1;
        while(i < arr.length){
            nums[i] = arr[j];
            j--;
            i+=2;
        }
        
        // for even index
        i = 0;
        while(i < arr.length){
            nums[i] = arr[j];
            j--;
            i+=2;
        }
    }
}