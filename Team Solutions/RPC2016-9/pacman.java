import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * Solution made by prada
 */

public class pacman {

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
		int N = Integer.parseInt(in.readLine());
		int r, c;
		for (int casos = 1; casos <= N; casos++) {

			StringTokenizer stk = new StringTokenizer(in.readLine());
			r = Integer.parseInt(stk.nextToken());
			c = Integer.parseInt(stk.nextToken());
			int[][] board = new int[r][c];
			int[][] maxs = new int[r][c];

			board[0][0] = 0;
			board[r - 1][c - 1] = 0;
			String num;
			for (int i = 0; i < r; i++) {
				stk = new StringTokenizer(in.readLine());
				for (int j = 0; j < c; j++) {
					num = stk.nextToken();
					if(num.equals("P") || num.equals("E")) continue;
					board[i][j] = Integer.parseInt(num);
				}

			}
			
			
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < c; j++) {
					if (i == 0 && j == 0)
						maxs[i][j] = 0;
					else if (i == 0)
						maxs[i][j] = maxs[i][j - 1] + board[i][j];
					else if (j == 0)
						maxs[i][j] = maxs[i - 1][j] + board[i][j];
					else {
						if (maxs[i - 1][j] > maxs[i][j - 1])
							maxs[i][j] = maxs[i - 1][j] + board[i][j];
						else
							maxs[i][j] = maxs[i][j - 1] + board[i][j];
					}
				}
			}
			
			out.printf("Game Board #%d: %d\n", casos, maxs[r - 1][c - 1]);

		}
		out.close();
		in.close();

	}

}
