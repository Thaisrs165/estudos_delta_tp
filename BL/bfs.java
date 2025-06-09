import java.util.*;

public class BFS {

    public boolean bfs(int[][] L, int[] fonte, int[] destino, Queue<int[]> fila) {

        int m = L.length;
        int n = L[0].length;

        boolean[][] visitados = new boolean[m][n];
        int[][] dist = new int[m][n];

        int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        fila.add(new int[]{fonte[0], fonte[1]});
        visitados[fonte[0]][fonte[1]] = true;
        dist[fonte[0]][fonte[1]] = 0;

        while (!fila.isEmpty()){
            int[] prox = fila.poll();
            int row = prox[0];
            int col = prox[1];

            if ( row == destino[0] && col == destino[1]){
                return true;
            }

            for ( int[] d: dir){
                int newRow = row + d[0];
                int newCol = col + d[1];

                if ( newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visitados[newRow][newCol]){
                    fila.add(new int[]{newRow, newCol});
                    visitados[newRow][newCol] = true;
                    dist[newRow][newCol] = dist[row][col] + 1;
                }
            }
        }

        return false;

    }
}