import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.TreeMap;

public class addition {

	static String[] pizzaToString = new String[10];

	static TreeMap<String, Integer> pizzaToNum = new TreeMap<>();
	
	public static void main(String[] args) throws IOException {
		
		pizzaToString[0] = "xxxxxx...xx...xx...xx...xx...xxxxxx";
		pizzaToString[1] = "....x....x....x....x....x....x....x";
		pizzaToString[2] = "xxxxx....x....xxxxxxx....x....xxxxx";
		pizzaToString[3] = "xxxxx....x....xxxxxx....x....xxxxxx";
		pizzaToString[4] = "x...xx...xx...xxxxxx....x....x....x";
		pizzaToString[5] = "xxxxxx....x....xxxxx....x....xxxxxx";
		pizzaToString[6] = "xxxxxx....x....xxxxxx...xx...xxxxxx";
		pizzaToString[7] = "xxxxx....x....x....x....x....x....x";
		pizzaToString[8] = "xxxxxx...xx...xxxxxxx...xx...xxxxxx";
		pizzaToString[9] = "xxxxxx...xx...xxxxxx....x....xxxxxx";

		ArmarTreeMap();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String linea;

		int numDigitos;
		

		while ((linea = br.readLine()) != null) {

			linea += ".";
			numDigitos = linea.length() / 6;

			String[] arregloCosa = new String[numDigitos];

			for (int i = 0; i < arregloCosa.length; i++) {
				arregloCosa[i] = "";
			}
			
			int indiceSuma = 0;
			
			for (int j = 0; j < linea.length()-4; j = j + 6) {
				
				String sub = linea.substring(j, j + 5);
				
				if(sub.equals(".....")){
					indiceSuma = j/6;
				}
				
				arregloCosa[j/6] += sub;
				
			}

			for (int i = 0; i < 6; i++) {

				linea = br.readLine();
				
				for (int j = 0; j < linea.length()-4; j = j + 6) {
					
					arregloCosa[j/6] += linea.substring(j, j + 5);
					
				}
				
			}

//			for (int i = 0; i < arregloCosa.length; i++) {
//				bw.write(arregloCosa[i] + "\n");
//			}
			
			long num1 = 0;
			int pow = 0;
			
			for (int i = indiceSuma -1; i >= 0; i--) {
				num1 += ((int)Math.pow(10, pow))*ToNum(arregloCosa[i]);
				pow++;
			}
			
			long num2 = 0;
			pow = 0;
			
			for (int i = arregloCosa.length -1; i > indiceSuma; i--) {
				num2 += ((int)Math.pow(10, pow))*ToNum(arregloCosa[i]);
				pow++;
			}

			long resultado = num1 + num2;
			String resultadoS = resultado + "";
			
			String lineaRes;
			
			for (int i = 0; i < 7; i++) {
			
				lineaRes = "";
				
				for (int j = 0; j < resultadoS.length(); j++) {
					
					lineaRes += ToString(Character.getNumericValue(resultadoS.charAt(j))).substring(i*5, (i*5)+5) + ".";
					
				}
				
				bw.write(lineaRes.substring(0, lineaRes.length()-1) + "\n");
				
			}
						
		}

		bw.close();
		br.close();

	}

	private static void ArmarTreeMap() {

		for (int i = 0; i < pizzaToString.length; i++) {
			pizzaToNum.put(pizzaToString[i], i);
		}
		
	}

	private static String ToString(int i) {
		return pizzaToString[i];
	}

	private static int ToNum(String s) {
		return pizzaToNum.get(s);
	}

}
