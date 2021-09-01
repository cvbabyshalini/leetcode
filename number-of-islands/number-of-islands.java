class Solution {
    static char ch = '0';
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j] == '1' && visited[i][j] == false){
                    getComp(grid,visited,i,j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void getComp(char[][] grid, boolean[][] visited, int i , int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || visited[i][j] == true || grid[i][j] == '0'){
            return;
        }
        visited[i][j] = true;
        getComp(grid,visited, i+1,j);
        getComp(grid,visited, i,j+1);
        getComp(grid,visited, i-1,j);
        getComp(grid,visited, i,j-1);
    }
}