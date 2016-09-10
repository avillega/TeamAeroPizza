
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class twins {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String linea, number;
		StringTokenizer st;
		
		boolean mack, zack;
		
		linea = br.readLine();
		
		int casos = Integer.parseInt(linea);
		
		for(int i = 0; i < casos ; i++){
			
			zack = false;
			mack = false;
			
			linea = br.readLine();
			st = new StringTokenizer(linea);
			
			while(st.hasMoreTokens()){
				number = st.nextToken();
				
				if(number.equals("18")){

					mack = true;
					
					if(zack == true){
						break;
					}
					
				}
				else if(number.equals("17")){
					
					zack = true;
					
					if(mack == true){
						break;
					}
					
				}
				
				
			}
			
			bw.write(linea + "\n");
			
			if(mack && zack){
				bw.write("both\n");
			}
			else if(mack){
				bw.write("mack\n");
			}
			else if(zack){
				bw.write("zack\n");
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
