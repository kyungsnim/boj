package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P_11657 {
	static int N, M, A, B, C;
	static ArrayList<Integer> con[], conv[];
	static long D[][];
	static boolean update, isBug;
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		con = new ArrayList[N+1];
		conv = new ArrayList[N+1];
		D = new long[N+1][2];
		
		for(int i = 1; i <= N; i++) {
			con[i] = new ArrayList<>();
			conv[i] = new ArrayList<>();
			D[i][0] = Long.MAX_VALUE;
			D[i][1] = i;
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			con[A].add(B);
			conv[A].add(C);
		}
		
		bellman();
		
		if(isBug) {
			System.out.println("-1");
		} else {
			for(int i = 2; i <= N; i++) {
				if(D[i][0] == Long.MAX_VALUE) {
					System.out.println("-1");
				} else {
					System.out.println(D[i][0]);
				}
			}
		}
	}
	static void bellman() {
		D[1][0] = 0;
		D[1][1] = 1;
		
		for(int i = 1; i <= N; i++) {
			update = false;
			for(int j = 1; j <= N; j++) {
				int q = j;
				long d = D[q][0];
				
				if(D[q][0] != d) continue;
				for(int k = 0; k < con[q].size(); k++) {
					int t = con[q].get(k);
					int v = conv[q].get(k);
					
					if(D[t][0] > D[q][0] + v && D[q][0] != Long.MAX_VALUE) {
						D[t][0] = D[q][0] + v;
						D[t][1] = D[q][1]; // q
						update = true;
					}
				}
			}
			if(!update) {
				break;
			}
		}
		if(update) isBug = true;
	}
}
