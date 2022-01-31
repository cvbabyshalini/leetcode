class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int val : weights){
            sum += val;
            max = Math.max(val, max);
        }
        int lo = max;
        int hi = sum;
        int cap = Integer.MAX_VALUE;
        while(lo <= hi){
            int minCap = lo + (hi - lo) / 2;
            if(isMin(weights, minCap, days) == true){
                cap = minCap;
                hi = minCap - 1;
            }
            else{
                lo = minCap + 1;
            }
        }
        return cap;
    }
    private static boolean isMin(int[] arr, int cap, int days){
        int day = 1;
        int sum = 0;
        for(int i = 0 ; i < arr.length ; i++){
            sum += arr[i];
            if(sum > cap){
                sum = arr[i];
                day++;
            }
        }
        return day <= days;
    }
}