class Solution {
   public void solveSudoku(char[][] board) {
	solveSudokuUtil(board);
}

public boolean solveSudokuUtil(char[][] board) {
	// check first if the array is filled or not
	boolean isFull = true;
	int row = 0, col = 0;
	for(int i = 0; i < board.length; i++) {
		for(int j = 0; j < board.length; j++) {
			if(board[i][j] == '.') {
				isFull = false;
				row = i;
				col = j;
				break;
			}
		}
		if(!isFull)
			break;
	}
	// if the sudoku is already solved
	if(isFull) return true;

	// try to enter number from 1-9
	for(int num = 1; num <= 9; num++) {
		if(isSafe(board, row, col, (char)(num + '0'))) {
			board[row][col] = (char)(num + '0');
			// solve rest of the board until it get solved
			if(solveSudokuUtil(board)) {
				return true;   
			}
			// backtracking step
			board[row][col] = '.';

		}
	}

	return false;
}

public boolean isSafe(char[][] board, int row, int col, char num) {
	// check row
	for(int j = 0; j < board.length; j++) {
		if(board[row][j] == num)
			return false;
	}

	// check column
	for(int i = 0; i < board.length; i++) {
		if(board[i][col] == num) 
			return false;
	}

	// check block of 3X3 size
	int ni = row/3 * 3;
      int nj = col/3 * 3;
      for(int i = 0 ; i < 3 ; i++){
          for(int j = 0 ; j < 3 ; j++){
              if(board[ni+i][nj+j] == num)
                return false;
          }
      }

	return true;
}
}