class Solution {
    public double averageWaitingTime(int[][] customers) {
        double waiting_time = 0;
        
        waiting_time += customers[0][1];
        int curr_time = customers[0][0] + customers[0][1];
        
        for(int i=1; i<customers.length; i++){
            if(customers[i][0] <= curr_time){
                curr_time += customers[i][1];
                waiting_time += curr_time - customers[i][0];
            }
            else{
                waiting_time += customers[i][1];
                curr_time += (customers[i][0] - curr_time) + customers[i][1];
            }
        }
        return waiting_time/customers.length;
    }
}