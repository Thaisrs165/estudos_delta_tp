import java.util.*;

public class BFSSaida {
    
    public boolean encontrarSaida(int[][] L, int i, int j, Queue<int[]> fila, boolean[][] visitados) {

        int m = L.length;
        int n = L[0].length;

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        fila.add(new int[]{i,j});
        visitados[i][j] = true;

        while (!fila.isEmpty()){
            int[] prox = fila.poll();
            int row = prox[0];
            int col = prox[1];

            if (row == 0 || col == 0 || row == m-1 || col == n-1){
                return true;
            }

            for (int[] d : dir){
                int newRow = row + d[0];
                int newCol = col + d[1];

                if ( newRow > 0 && newRow < m-1 && newCol > 0 && newCol < n-1 && !visitados[newRow][newCol]){
                    fila.add(new int[]{newRow,newCol});
                    visitados[newRow][newCol] = true;
                }
            }
        }

        fila.poll();
        return false;


    }
}