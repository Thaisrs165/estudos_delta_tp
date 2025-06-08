// javac Main.java     # Compila
// java Main           # Roda

public class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[][] grid = {
            {1,1,1,1,1},
            {1,0,1,0,1},
            {1,1,1,1,1},
            {0,0,1,0,1},
            {1,1,1,1,1}
        };

        int result = sol.closedRegions(grid);
        System.out.println("Número de regiões fechadas: " + result);
    }
}

class Solution {
    public int closedRegions(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;
        int numRegions = 0;

        for ( int i=0; i<m; i++){
            if ( grid[i][0] == 0){
                dfs(grid, i,0);
            } if ( grid[i][n-1] == 0){
                dfs(grid, i,n-1);
            }
        }

        for ( int j=0; j<n; j++){
            if ( grid[0][j] == 0){
                dfs(grid, 0,j);
            } if ( grid[m-1][j] == 0){
                dfs(grid, m-1,j);
            }
        }

        for ( int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if ( grid[i][j] == 2){
                    grid[i][j] = 1;
                } if ( grid[i][j] == 0){
                    dfs(grid, i,j);
                    numRegions += 1;
                }
            }
        }

        return numRegions;

    }

    public void dfs(int[][] grid, int i, int j){

        int m = grid.length;
        int n = grid[0].length;

        if ( i<0 || i >=m || j<0 || j>=n || grid[i][j] != 0){
            return;
        }

        grid[i][j] = 2;

        dfs(grid, i+1,j);
        dfs(grid, i-1,j);
        dfs(grid, i,j+1);
        dfs(grid, i,j-1);

    }
} 
