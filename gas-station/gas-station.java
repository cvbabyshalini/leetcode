class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0 ;
        int costSum = 0 ;
        for(int i = 0 ; i < gas.length ; i++){
            gasSum += gas[i];
            costSum += cost[i];
        }
        
        if(gasSum - costSum < 0){
            return -1;
        }
        
        int prefixSum = 0 ;
        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 0 ; i < gas.length ; i++){
            prefixSum += gas[i] - cost[i];
            
            if(prefixSum < min){
                min = prefixSum;
                idx = i;
            }
        }
        return (idx + 1) % gas.length;
    }
}