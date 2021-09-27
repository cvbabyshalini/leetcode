class Solution {
    static int[] xdir = {-1, 0, 1, 0};
    static int[] ydir = {0, -1, 0, 1};
    
    public static void numEnclaves_dfs(int[][] grid, int x, int y){
        grid[x][y] = 0;
        for(int d = 0 ; d < 4 ; d++){
            int r = x + xdir[d];
            int c = y + ydir[d];
            
            if(r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] != 0)
                numEnclaves_dfs(grid, r, c);
        }
    }
    public int numEnclaves(int[][] grid) {
        for(int c = 0 ; c < grid[0].length ; c++){
            if(grid[0][c] == 1){
                numEnclaves_dfs(grid , 0 , c);
            }
        }
        for(int c = 0 ; c < grid[0].length ; c++){
            if(grid[grid.length - 1][c] == 1){
                numEnclaves_dfs(grid , grid.length - 1 , c);
            }
        }
        for(int r = 0 ; r < grid.length ; r++){
            if(grid[r][0] == 1){
                numEnclaves_dfs(grid , r , 0);
            }
        }
        for(int r = 0 ; r < grid.length ; r++){
            if(grid[r][grid[0].length - 1] == 1){
                numEnclaves_dfs(grid , r , grid[0].length - 1);
            }
        }
        
        int one = 0 ;
        for(int r = 0 ; r < grid.length ; r++){
            for(int c = 0 ; c < grid[0].length ; c++){
                if(grid[r][c] == 1)
                    one++;
            }
        }
        return one;
    }
}