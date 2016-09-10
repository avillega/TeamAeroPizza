import java.io.*;
import java.util.StringTokenizer;

public class A{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String linea;

        StringTokenizer st;

        while((linea = br.readLine())!=null){

            st = new StringTokenizer(linea);

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == b || b==c || a==c){
                bw.write("S\n");
            }
            else if (a+b-c == 0 || b+c-a == 0 || a+c-b == 0 || a-b-c == 0 || b-a-c == 0 || c-a-b == 0){
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
