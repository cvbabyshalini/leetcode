class Solution {
    public static void makeMapWithStandAndBus(int[][] routes, HashMap<Integer, ArrayList<Integer>> map){
        for(int r = 0 ; r < routes.length ; r++){
            for(int c = 0 ; c < routes[r].length ; c++){
                int stand = routes[r][c];
                if(map.containsKey(stand) == true)
                    map.get(stand).add(r);
                else{
                    ArrayList<Integer> busNo = new ArrayList<>();
                    busNo.add(r);
                    map.put(stand, busNo);
                }
            }
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        makeMapWithStandAndBus(routes, map);
        
        HashSet<Integer> visBus = new HashSet<>();
        HashSet<Integer> visStand = new HashSet<>();
        Queue<Integer> qu = new ArrayDeque<>();
        qu.add(source);
        int level = -1 ; 
        
        while(qu.size() > 0){
            int size = qu.size();
            level++;
            while(size-- > 0){
                int rem = qu.remove();
                if(rem == target)
                    return level;
                for(int busNo: map.get(rem)){
                    if(visBus.contains(busNo) == true)
                        continue;
                    else{
                        for(int busStand: routes[busNo]){
                            if(visStand.contains(busStand) == false){
                                visStand.add(busStand);
                                qu.add(busStand);
                            }
                        }
                        visBus.add(busNo);
                    }
                }
            }
        }
        return -1;
    }
}