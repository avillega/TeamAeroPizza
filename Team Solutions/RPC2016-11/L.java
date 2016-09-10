import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class L {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String linea;
		StringTokenizer st;

		while ((linea = br.readLine()) != null) {

			st = new StringTokenizer(linea);

			int alto = Integer.parseInt(st.nextToken());
			int ancho = Integer.parseInt(st.nextToken());

			int[][] matriz = new int[alto + 2][ancho + 2];

			// inicializar matriz
			for (int i = 0; i < alto; i++) {

				linea = br.readLine();
				st = new StringTokenizer(linea);

				for (int j = 0; j < ancho; j++) {

					matriz[i + 1][j + 1] = Integer.parseInt(st.nextToken());

				}

			}

			// llenar bordes de -1
			for (int i = 0; i < matriz.length; i++) {

				matriz[i][0] = -1;
				matriz[i][matriz[i].length - 1] = -1;

			}
			for (int i = 0; i < matriz[0].length; i++) {
				matriz[0][i] = -1;
				matriz[matriz.length - 1][i] = -1;
			}

			int menor = 50000;
			
			for (int i = 1; i < matriz.length - 1; i++) {
				
				for (int j = 1; j < matriz[0].length - 1; j++) {
					
					if(matriz[i][j] != -1){
						
						menor = Math.min(menor, EncontrarMenor(matriz, i, j, matriz[i][j]));
						
					}
					
				}
				
			}
			
			bw.write(menor+"\n");
			
		}

		bw.flush();
		bw.close();
		br.close();

	}
	
	private static int EncontrarMenor(int[][] matriz, int i, int j, int color) {
		
		int count = 1;
		
		if(matriz[i][j] == color){
			matriz[i][j] = -1;
			count += EncontrarMenor(matriz, i-1, j, color);
			count += EncontrarMenor(matriz, i+1, j, color);
			count += EncontrarMenor(matriz, i, j-1, color);
			count += EncontrarMenor(matriz, i, j+1, color);
			return count;
		}
		else{
			return 0;
		}
		
	}

}
