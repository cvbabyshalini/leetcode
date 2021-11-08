class Solution {
    public List<List<String>> solveNQueens(int n) {
        boolean[] cols = new boolean[n];
        boolean[] d1 = new boolean[2 * n - 1];
        boolean[] d2 = new boolean[2 * n - 1];
        boolean[][] chess = new boolean[n][n];
        List<List<String>> ans = new ArrayList<>();
        nQueens(chess, 0, cols, d1, d2, ans);
        return ans;
        
    }
    public static void nQueens(boolean[][] chess, int i, boolean[] cols,boolean[] d1, boolean[] d2, List<List<String>> ans){
        if(i == chess.length){
            List<String> l = new ArrayList<>();
            for(int r = 0 ; r < chess.length ; r++){
                StringBuilder s = new StringBuilder();
                for(int c = 0 ; c < chess.length ; c++){
                    if(chess[r][c] == true)
                        s.append("Q");
                    else
                        s.append(".");
                }
                l.add(s.toString());
                s= new StringBuilder();
            }
            ans.add(l);
        return;
    }
    for(int j = 0 ; j < chess.length ; j++){
        if(cols[j] == false && d1[i+j] == false && d2[i-j+chess.length-1] == false){
            chess[i][j] = true;
            cols[j] = true;
            d1[i+j] = true;
            d2[i-j+chess.length-1] = true;
            nQueens(chess, i + 1, cols, d1, d2, ans);
            chess[i][j] = false;
            cols[j] = false;
            d1[i+j] = false;
            d2[i-j+chess.length-1] = false;
        }
    }
    }
}