class Solution {
    public int reachNumber(int target) {
        target = Math.abs(target);
        
        int s = 0 ;
        int jump = 0;
        
        while(s < target){
            jump++;
            s += jump;
        }
        if(s == target)
            return jump;
        else if((s - target) % 2 == 0)
            return jump;
        else if((s - target + jump + 1) % 2 == 0)
            return jump + 1;
        else
            return jump + 2;
    }
}