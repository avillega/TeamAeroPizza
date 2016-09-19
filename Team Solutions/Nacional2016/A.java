import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Locale;
import java.util.StringTokenizer;

public class A {
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		String linea;
		StringTokenizer tk;
		while (!(linea = in.readLine()).equals("*")) {
			int vertices=Integer.parseInt(linea);
			tk=new StringTokenizer(in.readLine());
			Punto base=new Punto(Double.parseDouble(tk.nextToken()), Double.parseDouble(tk.nextToken()));
			Punto[] poligono=new Punto[vertices];
			for(int i=0;i<vertices;i++){
				tk=new StringTokenizer(in.readLine());
				poligono[i]=new Punto(Double.parseDouble(tk.nextToken()), Double.parseDouble(tk.nextToken()));
			}
			double distMin=Double.POSITIVE_INFINITY;
			for(int i=0;i<poligono.length-1;i++){
				Punto a=poligono[i];
				Punto b=poligono[i+1];
				double answ=distanciaASegmento(base, a, b, new Punto(0, 0));
				distMin=Math.min(distMin, answ);
			}
			Punto aux1=poligono[0];
			Punto aux2=poligono[poligono.length-1];
			double answ=distanciaASegmento(base,aux2,aux1, new Punto(0, 0));
			distMin=Math.min(distMin, answ);
			
			out.printf(new Locale("en"), "%.3f%n", distMin);
			
		}

		in.close();
		out.close();
	}

	public static double distanciaALinea(Punto p,Punto a, Punto b, Punto c){
		Vector ap=toVec(a, p);
		Vector ab=toVec(a, b);
		
		double u=productoPunto(ap, ab)/norma(ab);
		c=transladar(a, scale(ab, u));
		return distancia(p, c);
	}
	
	public static double distanciaASegmento(Punto p,Punto a, Punto b, Punto c){
		Vector ap=toVec(a, p);
		Vector ab=toVec(a, b);
		double u=productoPunto(ap, ab)/norma(ab);
		if(u<0.0){
			c=new Punto(a.x, a.y);
			return distancia(p, a);
		}
		if(u>1.0){
			c=new Punto(b.x, b.y);
			return distancia(p, b);
		}
		return distanciaALinea(p, a, b, c);
	}

	public static class Punto {
		double x, y;

		public Punto(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	public static class Vector {
		double x, y;

		public Vector(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	public static double distancia(Punto a, Punto b) {
		double dx = a.x - b.x;
		double dy = a.y - b.y;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public static Vector toVec(Punto a, Punto b) {
		return new Vector(b.x - a.x, b.y - a.y);
	}

	public static Vector scale(Vector v, double s) {
		return new Vector(v.x * s, v.y * s);
	}

	public static Punto transladar(Punto p, Vector v) {
		return new Punto(p.x + v.x, p.y + v.y);
	}

	public static double productoPunto(Vector a, Vector b) {
		return a.x * b.x + a.y * b.y;
	}

	public static double norma(Vector v) {
		return v.x * v.x + v.y * v.y;
	}
}
