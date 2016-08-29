
import java.io.*;

/**
 * Created by Felipe on 7/9/2016.
 */
public class sweet
{

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String linea = br.readLine();

        int numero = Integer.parseInt(linea);

        int i = 1;

        int total = 0;

        while(numero != 0){

            total += numero;

            if(total >= 100){
                bw.write("Input #" + i + ": Totally Sweet!\n");
                total = total%50;
            }
            else if (total >= 50){
                bw.write("Input #" + i + ": Sweet!\n");
                total -= 50;
            }

            i++;
            linea = br.readLine();
            numero = Integer.parseInt(linea);

        }

        bw.flush();
        bw.close();
        br.close();

    }

}
