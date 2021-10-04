class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length * mat[0].length != r * c)
                return mat;
        int[] helper = new int[mat.length * mat[0].length];
        for(int i = 0 ; i < helper.length ;i++){
            helper[i] = mat[i/mat[0].length][i%mat[0].length];
        }
        int[][] res = new int[r][c];
        for(int i = 0 ; i < helper.length ; i++){
            res[i/c][i%c] = helper[i];
        }
        return res;
    }
}