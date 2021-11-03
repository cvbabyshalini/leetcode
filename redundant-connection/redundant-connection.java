class Solution {
    public int find(int[] parent, int x){
        if(parent[x] == x){
            return x;
        }
        int temp = find(parent, parent[x]);
        parent[x] = temp;
        return temp;
    }
    public void union(int lx, int ly, int[] rank, int[] parent){
        if(rank[lx] > rank[ly])
            parent[ly] = lx;
        else if(rank[lx] < rank[ly])
            parent[lx] = ly;
        else{
             parent[ly] = lx;
            rank[lx]++;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        // no of vertices
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for(int i = 0 ; i <= n ; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            // find set leader of u and v
            int lu = find(parent, u);
            int lv = find(parent, v);
            if(lu == lv){
                // it means u-v edge is responsible for cycle
                return edge;
            }
            union(lu, lv, rank, parent);
        }
        return new int[0];
    }
}