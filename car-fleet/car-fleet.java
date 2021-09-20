class Solution {
    private class Pair implements Comparable<Pair>{
        int pos;
        int speed;
        Pair(int pos, int speed){
            this.pos= pos;
            this.speed = speed;
        }
        public int compareTo(Pair o){
            return this.pos - o.pos;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ; i < position.length ; i++){
            pq.add(new Pair(position[i],speed [i]));
        }
        double maxT = 0;
        int fleets = 0 ;
        while(pq.size() > 0){
            Pair rem = pq.remove();
            double time = (target - rem.pos)/(rem.speed * 1.0);
            if(time > maxT){
                fleets++;
                maxT = time;
            }
        }
        return fleets;
    }
}