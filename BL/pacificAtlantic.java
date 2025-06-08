import java.util.*;

public class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        List<List<Integer>> result = new ArrayList<>();

        boolean[][] pacificVisited = new boolean[m][n];
        boolean[][] atlanticVisited = new boolean[m][n];

        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        for ( int i=0; i<m ; i++){
            pacificVisited[i][0] = true;
            atlanticVisited[i][n-1] = true;

            pacificQueue.add(new int[]{i,0});
            atlanticQueue.add(new int[]{i,n-1});
        }

        for ( int j=0; j<n; j++){
            pacificVisited[0][j] = true;
            atlanticVisited[m-1][j] = true;

            pacificQueue.add(new int[]{0,j});
            atlanticQueue.add(new int[]{m-1,j});
        }

        bfs(heights, pacificVisited, pacificQueue, dir);
        bfs(heights, atlanticVisited, atlanticQueue, dir);


        for ( int i=0; i<m ; i++){
            for ( int j=0; j<n; j++){
                if (pacificVisited[i][j] && atlanticVisited[i][j]){
                    result.add(Arrays.asList(i, j));
                }
            } 
        }

        return result;

    }

    public void bfs(int[][] heights, boolean[][] visted, Queue<int[]> queue, int[][] dir){

        int m = heights.length;
        int n = heights[0].length;

        while (!queue.isEmpty()){
            int[] prox = queue.poll(); 
            int row = prox[0];
            int col = prox[1];

            for (int[] d : dir){
                newRow = row + dir[0];
                newCol = col + dir[1];

                if (newRow>= 0 && newRow<m && newCol>=0 && newCol<n && !visted[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]){
                    visited[newRow][newCol] = true;
                    queue.add(new int[]{newRow,newCol});
                }
            }
        }

    }
}