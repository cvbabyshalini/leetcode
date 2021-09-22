class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int len = 0 ;
        int[] arr = new int[1001];
        for(int i = 0 ; i < trips.length ; i++){
            int val = trips[i][0];
            int sp = trips[i][1];
            int ep = trips[i][2];
            
            arr[sp] += val;
            arr[ep] -= val;
            len = Math.max(len, ep);
        }
        int prefixSum = 0 ;
        for(int i = 0 ; i <= len ; i++){
            prefixSum += arr[i];
            arr[i] = prefixSum;
            if(arr[i] > capacity){
                return false;
            }
        }
        return true;
    }
}