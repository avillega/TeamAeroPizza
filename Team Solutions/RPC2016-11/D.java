import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class D {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String linea;
		StringTokenizer st;
		
		long A,B,C,D;
		
		while((linea = br.readLine())!=null){
		
			st = new StringTokenizer(linea);
			
			A = Long.parseLong(st.nextToken());
			B = Long.parseLong(st.nextToken());
			C = Long.parseLong(st.nextToken());
			D = Long.parseLong(st.nextToken());
			
			long n = -1;
			
			if(A == B || C == D){
				
			}
			else{
				for (long i = A; i <= C && n == -1; i += A) {
					if(i%B != 0 && C%i == 0 && D%i !=0){
						n = i;
					}
				}				
			}
			
			
			bw.write(n+"\n");
			
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
