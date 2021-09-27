class Solution {
    
    static int[] xdir = {-1 , 0 , 1 , 0};
    static int[] ydir = {0 , -1 , 0 , 1};
    public class OPair {
        int r ; 
        int c ;
        int t ;
        public OPair(int r , int c , int t ){
            this.r = r;
            this.c = c;
            this.t = t ;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<OPair> q = new ArrayDeque<>();
        int orange = 0 ;
        // travel on grid and add rotten oranges in the queue and count total no. of oranges
        
        for(int r = 0 ; r < grid.length ; r++){
            for(int c = 0 ; c < grid[0].length ; c++){
                if(grid[r][c] == 2)
                    q.add(new OPair(r, c, 0));
                if(grid[r][c] == 2 || grid[r][c] == 1)
                    orange++;
            }
        }
        
        int time = 0;
        while(q.size() > 0){
            OPair rem = q.remove();
            
            if(grid[rem.r][rem.c] == -2)
                continue;
            
            grid[rem.r][rem.c] = -2 ; 
            
            orange--;
            time = rem.t ;
            
            for(int d = 0 ; d < 4 ; d++){
                int x = rem.r + xdir[d] ; 
                int y = rem.c + ydir[d];
                
                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == 1){
                    q.add(new OPair(x , y , rem.t + 1));
                }
            }
        }
        
        return orange == 0 ? time : -1 ;
    }
}