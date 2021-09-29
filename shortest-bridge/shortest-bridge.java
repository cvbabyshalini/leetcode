class Solution {
    
    static int[] xdir = {-1, 0, 1, 0};
    static int[] ydir = {0, -1, 0 ,1};
    
    public static class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    
    public static void dfsShortestBridge(int[][] grid, int x, int y, Queue<Pair> qu ){
        grid[x][y] = -1;
        qu.add(new Pair(x, y));
        for(int d = 0 ; d < 4 ; d++){
            int r = x + xdir[d];
            int c = y + ydir[d];
            
            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == 1){
                dfsShortestBridge(grid, r, c, qu);
            }
        }
    }
    public int shortestBridge(int[][] grid) {
        Queue<Pair> qu = new ArrayDeque<>();
        for(int i = 0 ; i < grid.length ; i++){
            boolean flag = true;
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == 1){
                    dfsShortestBridge(grid, i, j, qu);
                    flag = false;
                    break;
                }
            }
            if(flag == false)
                break;
        }
        
        int level = -1;
        while(qu.size() > 0){
            level++;
            int size = qu.size();
            while(size-- > 0){
                Pair rem = qu.remove();
                for(int d = 0 ; d < 4 ; d++){
                    int r = rem.x + xdir[d];
                    int c = rem.y + ydir[d];
                    
                    if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != -1){
                        if(grid[r][c] == 1)
                            return level;
                        
                        grid[r][c] = -1;
                        qu.add(new Pair(r, c));
                    }
                }
            }
        }
        return level;
    }
}