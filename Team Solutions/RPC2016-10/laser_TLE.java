import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;

public class laser {
	
	static ArrayList<Integer> criba(int N){
		boolean[] marcado = new boolean[N+1];
		ArrayList<Integer> ret = new ArrayList<>(N);
		for(int i= 2; i< Math.sqrt(N) ; i++ ){
			if(!marcado[i]){				
				for (int j = i+i; j < N+1; j+=i) {
					marcado[j]=true;
				}
			}
		}
		for (int i = 2; i < marcado.length; i++) {
			if(!marcado[i]) ret.add(i);
		}
		return ret;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		LinkedList<Par> factores = new LinkedList<>();
		ArrayList<Integer> primos = criba(100000);
		ArrayList<Integer> copiaPrimos; 
		int N = Integer.parseInt(in.readLine());
		int num;
		int total = 1;
		for (int casos = 0; casos < N; casos++) {
			factores= new LinkedList<>();
		
			num = Integer.parseInt(in.readLine());
			int primo = primos.get(0);
			total = 1;
			int i =0;
			while(num > 1){
				Par par = new Par();
				par.num = primo;
				par.cant = 0;
				while(num%primo == 0){
					num/=primo;
					par.cant++;
				}
				if(par.cant > 0) total*= (par.num-1) * Math.pow(par.num, par.cant-1);
				i++;
				primo = primos.get(i);
			}
			
			
			out.write(total+"\n");
			
		}
		out.close();
		in.close();

	}
	
	public static class Par{
		int num;
		int cant;
	}
	
//	static int potencia(int a, int b){
//		if(b==0) return 1;
//		int ret = a;
//		for (int i = 1; i < b; i++){
//			ret*=a;			
//		}
//		return ret;
//	}

}
