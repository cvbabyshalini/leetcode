class Solution {
    public int maxChunksToSorted(int[] arr) {
        int[] leftmax = new int[arr.length];
        int[] rightmin = new int[arr.length];
        
        leftmax[0] = arr[0];
        for(int i = 1; i < arr.length ; i++){
            leftmax[i] = Math.max(leftmax[i -1], arr[i]);
        }
        
        rightmin[arr.length - 1] = arr[arr.length - 1];
        for(int i = arr.length - 2 ; i >= 0 ; i--){
            rightmin[i] = Math.min(rightmin[i + 1], arr[i]);
        }
        
        int chunks = 1 ;
        for(int i = 0 ; i < arr.length - 1 ; i++){
            if(leftmax[i] <= rightmin[i + 1]){
                chunks++;
            }
        }
        return chunks;
    }
}