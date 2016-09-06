import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class constant{

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		int casos=1,n,t=Integer.parseInt(in.readLine());
		StringTokenizer tk;
		while (t-->0) {
			int[] coef=new int[8];
			tk=new StringTokenizer(in.readLine());
			for(int i=0;i<8;i++) coef[i]=Integer.parseInt(tk.nextToken());
			n=Integer.parseInt(tk.nextToken());
			out.write("Equation #"+(casos++)+": "+countSolutions(coef, n)+"\n");
		}
		in.close();
		out.flush();
		out.close();
	}
	
	public static long countSolutions(int[] a, int b) {
	    long[] dp = new long[b + 1];
	    dp[0] = 1;
	    for (int i = 0; i < a.length; i++) {
	      for (int j = a[i]; j <= b; j++) {
	        dp[j] += dp[j - a[i]];
	      }
	    }
	    return dp[b];
	  }

}
