class Solution {
    public int find(int[] parent, int x){
        if(parent[x] == x)
            return x;
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
    public boolean equationsPossible(String[] equations) {
        // process '==' and union them
        int[] parent = new int[26];
        int[] rank = new int[26];
        for(int i = 0 ; i < 26 ; i++){
            parent[i] = i;
            rank[i] = 1;
        }
        for(int i = 0 ; i < equations.length ; i++){
            if(equations[i].charAt(1) == '='){
                int x = equations[i].charAt(0) - 'a';
                int y = equations[i].charAt(3) - 'a';
                int lx= find(parent, x);
                int ly = find(parent, y);
                if(lx == ly)
                    continue;
                union(lx, ly, rank, parent);
            }
        }
        
        // check set leader for '!=' inequality if same then return false
        for(int i = 0 ; i < equations.length ; i++){
            if(equations[i].charAt(1) == '!'){
                int x = equations[i].charAt(0) - 'a';
                int y = equations[i].charAt(3) - 'a';
                int lx = find(parent, x);
                int ly = find(parent, y);
                if(lx == ly)
                    return false;
            }
        }
        return true;
    }
}