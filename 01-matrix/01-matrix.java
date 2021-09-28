class Solution {
    
    static int[] xdir = {-1, 0, 1, 0};
    static int[] ydir = {0, -1, 0, 1};
    
    public static class Pair01{
        int i ;
        int j ;
        Pair01(int i , int j ){
            this.i = i;
            this.j = j;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair01> qu = new ArrayDeque<>();
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        
        for(int i = 0 ; i < mat.length ; i++){
            for(int j = 0 ; j < mat[0].length ; j++){
                if(mat[i][j] == 0){
                    qu.add(new Pair01(i, j));
                    vis[i][j] = true;
                }
            }
        }
        
        int level = -1;
        while(qu.size() > 0){
            int size = qu.size();
            level++;
            while(size-- > 0){
                Pair01 rem = qu.remove();
                mat[rem.i][rem.j] = level ;
                for(int d = 0 ; d < 4 ; d++){
                    int r = rem.i + xdir[d];
                    int c = rem.j + ydir[d];
                    
                    if(r >= 0 && r < mat.length && c >= 0 && c < mat[0].length && vis[r][c] == false){
                        qu.add(new Pair01(r, c));
                        vis[r][c] = true;
                    }
                }
            }
        }
        return mat;
    }
}