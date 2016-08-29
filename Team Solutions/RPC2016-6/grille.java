import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class grille {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out=new BufferedWriter(new OutputStreamWriter(System.out));
		
		int size = Integer.parseInt(in.readLine());
		ArrayList<Position> positionsG = new ArrayList<Position>();
		
		for (int i = 0; i < size; i++) {
			
			char[] ln = in.readLine().toCharArray();
			
			for (int j = 0; j < ln.length; j++) {
				if(ln[j]=='.') positionsG.add(new Position(i, j));
			}
			
		}
		
		char[] message = in.readLine().toCharArray();
		char[] decripted = new char[message.length];
		boolean[] visited = new boolean[size*size];
		boolean[] visitedDec = new boolean[size*size];
		
		Collections.sort(positionsG);
		int p =0;
		for (int i = 0; i < 4; i++) {
			
			for (Position pos : positionsG) {
				
				if(!visited[(pos.fila*size)+pos.col]){
					visited[(pos.fila*size)+pos.col]=true;
					visitedDec[p]=true;
					decripted[(pos.fila*size)+pos.col]=message[p];
					p++;
				}else{
					out.write("invalid grille\n");
					out.flush();
					out.close();
					in.close();	
					return;
				}
				pos.anticlock(size);
			}
			Collections.sort(positionsG);
			
		}
		for (int i = 0; i < visitedDec.length; i++) {
			if(!visitedDec[i]){
				out.write("invalid grille\n");
				out.flush();
				out.close();
				in.close();	
				return;
			}
		}
		for (int i = 0; i < visited.length; i++) {
			out.write(decripted[i]);
		}
		out.write("\n");
		out.flush();
		out.close();
		in.close();		
		
	}
	
	
	

}

class Position implements Comparable<Position>{
	
	int fila, col;
	public Position(int fila, int col){
		
		this.fila=fila;
		this.col=col;
		
	}
	
	public void setPos(int fila, int col){
		this.fila=fila;
		this.col=col;
	}
	
	public void anticlock(int l){
		l--;
		int temp = fila;
		fila=this.col;
		col=l-temp;		
	}

	@Override
	public int compareTo(Position o) {
		if(this.fila < o.fila) return -1;
		if(this.fila > o.fila) return 1;
		else{
			if(this.col < o.col) return -1;
			if(this.col > o.col) return 1;
		}
		return 0;
	}
}
