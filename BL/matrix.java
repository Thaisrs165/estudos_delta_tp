// poll() -> Remove e retorna o primeiro elemento

import java.util.*;

public class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int m = mat.length;
        int n = mat[0].length;

        int[][] dist = new int[m][n];
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();

        for ( int i=0; i<m; i++){
            for (int j=0; j<n; j++){
                if (mat[i][j] == 0){
                    queue.add(new int[]{i,j});
                    visited[i][j] = true;
                    dist[i][j] = 0;

                }
            }
        }

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}}

        while (!queue.isEmpty()){
            int[] prox = queue.poll();
            int row = prox[0];
            int col = prox[1];

            for ( int[] d : dir){
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if ( newRow >=0 && newRow < m && newCol >= 0 && newCol <n && !visited[newRow][newCol]){
                    queue.add(new int[]{newRow,newCol});
                    visited[newRow][newCol] = true;
                    dist[newRow][newCol] = dist[row][col] + 1;
                }
            }

        }

        return dist; 

    }
}