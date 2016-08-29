import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class pentastic {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String linea = br.readLine();
		
		int casos = Integer.parseInt(linea);
		
		for (int i = 0; i < casos; i++) {
			
			linea = br.readLine();
			
			bw.write("Pentagon #" + (i+1) + ":\n");
			
			bw.write(ProcesarPentagono(linea) + "\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}

	private static String ProcesarPentagono(String linea) {

		StringTokenizer st = new StringTokenizer(linea);
		
		int[] pentagono = new int[5];
		pentagono[0] = Integer.parseInt(st.nextToken());
		pentagono[1] = Integer.parseInt(st.nextToken());
		pentagono[2] = Integer.parseInt(st.nextToken());
		pentagono[3] = Integer.parseInt(st.nextToken());
		pentagono[4] = Integer.parseInt(st.nextToken());
		
		int[] par = BuscarMenor(pentagono);
		
		while(par[0] < 0){
			
			if(par[1] == 4){
				pentagono[3] += par[0];
				pentagono[0] += par[0];
			}
			else if (par[1] == 0){
				pentagono[1] += par[0]; 
				pentagono[4] += par[0]; 
			}
			else{
				pentagono[par[1] - 1] += par[0]; 
				pentagono[par[1] + 1] += par[0]; 

			}
		
			pentagono[par[1]] = -pentagono[par[1]];
			
			par = BuscarMenor(pentagono);
			
		}
		
		return pentagono[0] + " " + pentagono[1] + " " + pentagono[2] + " " + pentagono[3] + " " + pentagono[4];
		
	}

	private static int[] BuscarMenor(int[] pentagono) {

		int[] par = new int[2];
		par[0] = pentagono[0];
		par[1] = 0;
		
		for (int i = 1; i < pentagono.length; i++) {
			
			if(pentagono[i] < par[0]){
				par[0] = pentagono[i];
				par[1] = i;
			}
			
		}
		
		return par;
		
	}

}
