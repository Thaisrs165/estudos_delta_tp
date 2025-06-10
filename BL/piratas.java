import java.util.*;

public class Encontro {

    public static boolean existeIlhaParaEncontro(int[][] m, int[] navio1, int[][] menoresCaminhosN1, int[] navio2,
            int[][] menoresCaminhosN2, ArrayList<int[]> caminho1, ArrayList<int[]> caminho2) {

                int altura = m.length;
                int largura = m[0].length;

                for ( int i =0; i<altura; i++){
                    for ( int j = 0; j<largura; j++){
                        if (m.ehIlha(i,j)){
                            int dist1 = menoresCaminhosN1[i][j];
                            int dist2 = menoresCaminhosN2[i][j];

                            if (dist1 != 1 && dist2 != 1 && dist1 == dist2){
                                int[] ilha = new int[]{i,j};
                                caminho1.addAll(reconstroiCaminho(menoresCaminhosN1, navio1, ilha));
                                caminho2.addAll(reconstroiCaminho(menoresCaminhosN2, navio2. ilha));
                                return true;
                            }

                        }
                    }
                }

                return false;

            }

    private static ArrayList<int[]> reconstroiCaminho(int[][] distancias, int[] origem, int[] destino){

        int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

        ArrayList<int[]> caminho = new ArrayList<>();
        int[] atual = destino;
        caminho.add(0,atual);

        while(atual[0] != origem[0] || atual[1] != origem[1]){
            int i = atual[0];
            int j = atual[1];
            
            for ( int[] d: dir){
                int ni = i + d[0];
                int nj = j + d[1];

                if (ni >= 0 && ni < distancias.length && nj >= 0 && nj < distancias[0].length){
                    if (distancias[ni][nj] == distancias[i][j] - 1){
                        atual = new int[]{ni, nj};
                        caminho.add(0,atual);
                    }
                }
            }
        } 

        return caminho; 

    }
}