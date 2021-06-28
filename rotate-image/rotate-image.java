class Solution {
    public void rotate(int[][] matrix) {
        
        for(int i =  0 ; i < matrix.length-1 ; i++){
            for(int j = i + 1 ; j < matrix.length ; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int left = 0;
        int right = matrix.length - 1;
        while(left<right){
            for(int row = 0 ; row < matrix.length ; row++){
                int temp = matrix[row][left];
                matrix[row][left] = matrix[row][right];
                matrix[row][right] = temp;
            }
            left++;
            right--;
        }
        
    }
}