class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;

        for ( int i=0; i<m; i++){
            for ( int j=0; j<n ; j++){
                if (grid[i][j] == 1){
                    int area = dfs(grid, i, j);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }

        return maxArea; 

    }

    public int dfs( int[][] grid, int i, int j){

        int m = grid.length;
        int n = grid[0].length;

        if ( i<0 || i>=m || j<0 || j>=n || grid[i][j] != 1;){
            return;
        }

        board[i][j] = 0;
        int count = 1;

        count += dfs(grid, i+1, j);
        count += dfs(grid, i-1, j);
        count += dfs(grid, i, j+1);
        count += dfs(grid, i, j-1);

        return count; 

    }
}