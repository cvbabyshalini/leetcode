class Solution {
    public int minDominoRotations(int[] tops, int[] bottoms) {
        int val1 = tops[0];
        int val2 = bottoms[0];
        
        int count1 = 0 ; // Rotations to make top as val1
        int count2 = 0 ; // Rotations to make top as val2
        int count3 = 0 ; // Rotations to make bottom as val1
        int count4 = 0 ; // Rotations to make bottom as val2
        
        for(int i = 0 ; i < tops.length ; i++){
            if(count1 != Integer.MAX_VALUE){
                if(tops[i] == val1){
                    // nothing to do
                }
                else if(bottoms[i] == val1){
                    count1++;
                }
                else{
                    count1 = Integer.MAX_VALUE;
                }
            }
            
            if(count2 != Integer.MAX_VALUE){
                if(tops[i] == val2){
                    // nothing to do
                }
                else if(bottoms[i] == val2){
                    count2++;
                }
                else{
                    count2 = Integer.MAX_VALUE;
                }
            }
            
            if(count3 != Integer.MAX_VALUE){
                if(bottoms[i] == val1){
                    // nothing to do
                }
                else if(tops[i] == val1){
                    count3++;
                }
                else{
                    count3 = Integer.MAX_VALUE;
                }
            }
            
            if(count4 != Integer.MAX_VALUE){
                if(bottoms[i] == val2){
                    // nothing to do
                }
                else if(tops[i] == val2){
                    count4++;
                }
                else{
                    count4 = Integer.MAX_VALUE;
                }
            }
        }
        int res = Math.min(Math.min(count1, count2),Math.min(count3, count4));
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}