class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int rmin = 0;
        int cmin = 0;
        int r =matrix.length;
        int c = matrix[0].length;
        int rmax = r-1;
        int cmax = c-1;
        ArrayList<Integer> l = new ArrayList<Integer>();
        while(l.size() < r*c){
            for(int col = cmin; col <= cmax; col++){
                l.add(matrix[rmin][col]);
            }
            rmin++;
            if(l.size() >= r*c){
                break;
            }
            for(int row = rmin; row <= rmax; row++){
                l.add(matrix[row][cmax]);
            }
            cmax--;
             if(l.size() >= r*c){
                break;
            }
            for(int col = cmax; col >= cmin; col--){
                l.add(matrix[rmax][col]);
            }
            rmax--;
             if(l.size() >= r*c){
                break;
            }
            for(int row = rmax; row >= rmin; row--){
                l.add(matrix[row][cmin]);
            }
            cmin++;
             if(l.size() >= r*c){
                break;
            }
        }
        return l;
        // code here 
        
    }
}