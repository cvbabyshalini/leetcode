class Solution {
    public int maxDistToClosest(int[] seats) {
        int dist = 1;
        int zeros = 0 ;
        int index = 0;
        // left subpart
        while(seats[index] != 1){
            zeros++;
             index++;
        }
        index++;
        dist = zeros;
        zeros = 0;
        // segment calculations
        while(index < seats.length){
            while(index < seats.length && seats[index] != 1){
                zeros++;
                index++;
            }
            if(index == seats.length){
                break;
            }
            index++;
            dist = Math.max(dist, (zeros + 1)/2);
            zeros = 0;
        }
        // right subpart
        return Math.max(dist, zeros);
    }
}