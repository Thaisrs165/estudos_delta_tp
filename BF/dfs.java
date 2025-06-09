import java.util.*;

public class DFS {

    boolean[][] visitados;

    public boolean dfs(int[][] L, int[] fonte, int[] destino, Queue<int[]> caminho) {

        int m = L.length;
        int n = L[0].length;

        if (fonte[0] < 0 || fonte[0] >=m || fonte[1] < 0 || fonte[1] >= n || visitados[fonte[0]][fonte[1]] || L[fonte[0]][fonte[1]] == 1) {
            return false;
        }

        visitados[fonte[0]][fonte[1]] = true;
        caminho.add(new int[]{fonte[0], fonte[1]});
        

        if (fonte[0] == destino[0] && fonte[1] == destino[1]){
            return true;
        } 


        if (dfs(L, new int[]{fonte[0]+1, fonte[1]}, destino, caminho) ||
            dfs(L, new int[]{fonte[0]-1, fonte[1]}, destino, caminho) ||
            dfs(L, new int[]{fonte[0], fonte[1]+1}, destino, caminho) ||
            dfs(L, new int[]{fonte[0], fonte[1]-1}, destino, caminho)) {
            return true;
        }

        caminho.poll();
        return false;

    }
}