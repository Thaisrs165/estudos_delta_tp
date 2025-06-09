import java.util.*;

public class DFSSaida {

    public boolean encontrarSaida(int[][] L, int i, int j, Queue<int[]> caminho, boolean[][] visitados) {

        int m = L.length;
        int n = L[0].length;

        if (i<0 || i>=m || j<0 || j>=n || L[i][j] == 1){
            return false;
        }

        visitados[i][j] = true;
        caminho.add(new int[]{i,j});

        if (i == 0 || j ==0 || i == m-1 || j == n-1){
            return true;
        }


        if ( encontrarSaida(L,i+1,j,caminho) ||
        encontrarSaida(L,i-1,j,caminho) || 
        encontrarSaida(L,i,j+1,caminho) || 
        encontrarSaida(L,i,j-1,caminho)){
            return true;
        }


        caminho.poll();
        return false;

    }


}