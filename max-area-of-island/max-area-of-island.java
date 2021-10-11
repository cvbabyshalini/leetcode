class Solution {
    int area = 0;                      //to store the area of current island
    int maxArea = 0;               //stores the largest area
    public int maxAreaOfIsland(int[][] grid) {
	
	//simple loop to search for all starts of island --- or components in graph terms
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 1){
				//if we get 1 it means, a new island has started so we call our dfs to the present island/component in graph terms
                    dfs(grid, i, j);
					//storing the largest area in our maxArea variable
                    maxArea = Math.max(area, maxArea);
                    area = 0;                  // reinitializing area to 0 for next island 
                }
            }
        }
        return maxArea;
    }
    
    public void dfs(int[][] grid, int i, int j){
	
	//base case - if the cell moves out of our grid we dont need to so anything, as that doesnt add to our area
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return;
        }
        
			//if we reach water or 0 we again dont need to add anything as it doesnt add to our area
        if(grid[i][j] == 0)return;
        
        // grid[i][j] == 1
        //this means adjacent cell has 1 and area must increase by 1
        if(grid[i][j] == 1){
            area++;
        }
        
		
		//if we reach an alreay visited land mass i.e, we simply retuurn 
        if(grid[i][j] == -1)return;
        grid[i][j] = -1;           //we need to ensure that we mark the current cell which has been visited as -1 
        
		
		//call dfs on all adjacent cells
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j+1);
        dfs(grid, i, j-1);
		
		//do upvote it really helps
    }
}