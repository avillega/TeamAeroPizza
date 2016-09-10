

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class medal {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String linea = br.readLine();
		StringTokenizer st;
		
		int casos = Integer.parseInt(linea);
		
		int gU,sU,bU, gR, sR,bR, totalU, totalR;
		
		boolean count, color;
		
		for(int i = 0; i < casos ; i++){
		
			count = false;
			color = false;
			
			linea = br.readLine();
			st = new StringTokenizer(linea);
			
			gU = Integer.parseInt(st.nextToken());
			sU = Integer.parseInt(st.nextToken());
			bU = Integer.parseInt(st.nextToken());
			totalU = gU + sU + bU;
			
			gR = Integer.parseInt(st.nextToken());
			sR = Integer.parseInt(st.nextToken());
			bR = Integer.parseInt(st.nextToken());
			totalR = gR + sR + bR;

			bw.write(linea + "\n");

			if(totalU > totalR){
				count = true;
			}
			
			if(gU > gR){
				color = true;
			}
			else if (gU == gR){
				
				if(sU > sR){
					color = true;
				}
				else if(sU == sR){
					
					if(bU > bR){
						color = true;
					}
					
				}
				
			}
			
			if(count && color){
				bw.write("both\n");
			}
			else if (count){
				bw.write("count\n");
			}
			else if (color){
				bw.write("color\n");
			}
			else{
				bw.write("none\n");
			}
			
		}
		
		bw.flush();
		bw.close();
		br.close();

		
	}

}
