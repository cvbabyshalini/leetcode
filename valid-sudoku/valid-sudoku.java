class Solution {
    public boolean isValidSudoku(char[][] board) {
        // integer arrays for marking numbers 
        int[][] row = new int[board.length][board[0].length];
        int[][] col = new int[board.length][board[0].length];
        int[] box = new int[9];
        
        // we use the outer two for loops for iterating over each of the nine boxes
        for (int i = 0; i < board.length; i+=3){
            for (int j = 0; j < board[0].length; j+= 3){
                // clear the box array for every new box!
                Arrays.fill(box, 0);
                for (int r = i; r < i + 3; r++){
                    for (int c = j; c < j + 3; c++){
                        if (board[r][c] == '.'){
                            continue;
                        }
                        int num = Character.getNumericValue(board[r][c]);
                        if (row[r][num - 1] != 0 || col[c][num - 1] != 0 || box[num - 1] != 0){
                            return false;
                        }else {
                            row[r][num - 1] = 1;
                            col[c][num - 1] = 1;
                            box[num - 1] = 1;
                        }
                    }
                }
            }
        }
        
        return true;
    }
}