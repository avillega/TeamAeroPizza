import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class squawk {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String linea = br.readLine();
		
		StringTokenizer st = new StringTokenizer(linea);
		
		int numNodos = Integer.parseInt(st.nextToken());
		int numAristas = Integer.parseInt(st.nextToken());
		int nodoInicial = Integer.parseInt(st.nextToken());
		int tiempo = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] listaAdy = new ArrayList[numNodos];
			
		for (int i = 0; i < listaAdy.length; i++) {
			listaAdy[i] = new ArrayList<Integer>();
		}
		
		for (int i = 0; i < numAristas; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			listaAdy[u].add(v);
			listaAdy[v].add(u);
			
		}
		
		if(tiempo == 0){
			bw.write(0+"\n");
		}
		else{
			
			long[][] matrizSquawk = new long[tiempo+1][numNodos];
			
			matrizSquawk[0][nodoInicial] = 1;
			
			for (int i = 1; i < tiempo + 1; i++) {
				
				for (int j = 0; j < numNodos; j++) {
										
					//if(matrizSquawk[i-1][j] == 0){
						
						ArrayList<Integer> adyacentes = listaAdy[j];
						
						long suma = 0;
						
						for (int k = 0; k < adyacentes.size(); k++) {
							
							suma += matrizSquawk[i-1][adyacentes.get(k)];
							
						}
						
						matrizSquawk[i][j] = suma;
						
					//}
					
				}
				
			}
			
			long total = 0;
			
			for (int i = 0; i < numNodos; i++) {
				
				total += matrizSquawk[tiempo][i];
				
			}			
			
			bw.write(total +"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
