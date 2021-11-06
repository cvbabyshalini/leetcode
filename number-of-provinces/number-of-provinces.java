class Solution {
    public void connectedComp(int[][] graph, int src, boolean[] vis){
        vis[src] = true;
        for(int nbr = 0 ; nbr < graph.length ; nbr++){
            if(graph[src][nbr] == 1 && vis[nbr] == false){
                connectedComp(graph, nbr, vis);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length ; 
        boolean[] vis = new boolean[n];
        int count = 0 ;
        for(int i = 0 ; i < n ; i++){
            if(vis[i] == false){
                count++;
                connectedComp(isConnected, i, vis);
            }
        }
        return count;
    }
}