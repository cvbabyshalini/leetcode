class Solution {
    public int pivotIndex(int[] arr) {
        int tsum = 0;
        for(int val : arr)
            tsum += val;
            
        int lsum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            tsum -= arr[i];
            if(tsum == lsum)
                return i;
            lsum += arr[i];
        }
        return -1;
    }
}