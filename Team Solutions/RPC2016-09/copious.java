import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class copious {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		
		int N = Integer.parseInt(in.readLine());
		ArrayList<char[]> dict = new ArrayList<char[]>();
		ArrayList<char[]> words = new ArrayList<char[]>();
		for (int pa = 0; pa < N; pa++) {
			dict.add(in.readLine().toCharArray());
		}
		N=Integer.parseInt(in.readLine());
		for (int i = 0; i < N; i++) {
			words.add(in.readLine().toCharArray());
		}
		ArrayList<char[]> posibles = dict;
		ArrayList<char[]> posiblesTemp = new ArrayList<char[]>();
		int number =1;
		for(char[] word : words){
			for (int i = 0; i < posibles.size(); i++) {
				if(posibles.get(i).length == word.length ) posiblesTemp.add(posibles.get(i));
			}
			posibles = posiblesTemp;
			posiblesTemp = new ArrayList<>();
			for (int i = 0; i < word.length; i++) {				
				if(word[i]!='-'){
					for (int j = 0; j < posibles.size(); j++) {
						char[] posiblePalabra = posibles.get(j);
						if(word[i] == posiblePalabra[i]) posiblesTemp.add(posiblePalabra);
					}
					posibles = posiblesTemp;
					posiblesTemp = new ArrayList<>();					
				}
			}
			out.printf("Word #%d: %s\n", number, new String(word));
			number++;
			for (char[] posible:posibles) {
				out.printf("%s\n", new String(posible));
			}
			out.printf("Total number of candidate words = %d\n", posibles.size());
			posibles = dict;
			posiblesTemp = new ArrayList<char[]>();
		}
		out.close();
		in.close();
		
		
	}

}
