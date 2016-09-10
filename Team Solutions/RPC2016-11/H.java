import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class H {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String linea, vocales, vocalesReverse;
		
		while((linea = br.readLine())!=null){
		
			vocales = "";
			vocalesReverse = "";
			
			for (int i = 0; i < linea.length(); i++) {

				char c = linea.charAt(i);

				if(c == 'a' || c == 'e' || c =='i' || c == 'o' || c == 'u'){
					vocales += c;
					vocalesReverse = c + vocalesReverse;
				}
				
			}

			if(vocales.equals(vocalesReverse)){
				bw.write("S\n");
			}
			else{
				bw.write("N\n");
			}
			
		}
		
		bw.flush();
		bw.close();
		br.close();
		
	}

}
