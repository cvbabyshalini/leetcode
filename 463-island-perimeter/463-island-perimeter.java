class Solution {
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
               if(grid[i][j]==1)
				   return dfsPerimeter(grid,i,j);
                }
            }
        

        return 0;
    }
    
	public int dfsPerimeter(int[][]grid,int i, int j){
	
	if(i<0 || i>=grid.length||j<0||j>=grid[0].length) return 1;
	if(grid[i][j]==0) return 1;
	if(grid[i][j]==-1) return 0;
	
	int count =0;
	grid[i][j]=-1;
	
	count+=dfsPerimeter(grid,i-1,j);
	count+=dfsPerimeter(grid,i,j-1);
	count+=dfsPerimeter(grid,i,j+1);
	count+=dfsPerimeter(grid,i+1,j);
	return count;
}
}