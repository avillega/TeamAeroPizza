import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class rings {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String linea = "";

		while ((linea = br.readLine()) != null) {

			StringTokenizer st = new StringTokenizer(linea);

			int x = Integer.parseInt(st.nextToken()) + 2;
			int y = Integer.parseInt(st.nextToken()) + 2;

			int[][] matriz = new int[x][y];

			int numTs = 0;

			for (int i = 1; i < x - 1; i++) {

				char[] lin = br.readLine().toCharArray();

				for (int j = 0; j < lin.length; j++) {

					if (lin[j] == 'T') {

						matriz[i][j + 1] = -1;
						numTs++;

					} else {

						matriz[i][j + 1] = 0;

					}

				}

			}

			int numCambios = 0;

			int anilloAnterior = 0;

			while (numCambios != numTs) {

				for (int i = 1; i < x - 1 && numCambios != numTs; i++) {

					for (int j = 1; j < y - 1 && numCambios != numTs; j++) {

						int num = matriz[i][j];

						if (num == -1) {

							int izq = -1;
							int der = -1;
							int top = -1;
							int bottom = -1;

							izq = matriz[i][j - 1];
							if (izq == anilloAnterior) {
								matriz[i][j] = izq + 1;
								numCambios++;
								continue;
							}

							der = matriz[i][j + 1];
							if (der == anilloAnterior) {
								matriz[i][j] = der + 1;
								numCambios++;
								continue;
							}

							top = matriz[i - 1][j];
							if (top == anilloAnterior) {
								matriz[i][j] = top + 1;
								numCambios++;
								continue;
							}

							bottom = matriz[i + 1][j];
							if (bottom == anilloAnterior) {
								matriz[i][j] = bottom + 1;
								numCambios++;
								continue;
							}

						}

					}

				}

				anilloAnterior++;

			}

			int numDigitos = (anilloAnterior + "").length() + 1;

			for (int i = 1; i < x - 1; i++) {

				String lineaArbol = "";

				for (int j = 1; j < y - 1; j++) {

					int num = matriz[i][j];

					int numPuntos = 0;

					if (num == 0) {

						numPuntos = numDigitos;

						lineaArbol += DarCasilla(numPuntos, num);

					} else {

						numPuntos = numDigitos - ((num + "").length() - 1);

						lineaArbol += DarCasilla(numPuntos, num);

					}

				}

				bw.write(lineaArbol + "\n");

			}

		}

		bw.flush();
		bw.close();
		br.close();

	}

	private static String DarCasilla(int numPuntos, int num) {

		String casilla = "";

		for (int i = 0; i < numPuntos - 1; i++) {

			casilla += ".";

		}

		if (num != 0) {
			casilla += num + "";
		}
		else{
			casilla += ".";
		}

		return casilla;

	}

}
