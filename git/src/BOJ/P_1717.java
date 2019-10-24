package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1717 {
	static int N, M, parent[], a, b, what;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		parent = new int[N+1];
		for(int i = 1; i <= N; i++){
			parent[i] = i;
		}
		
		for(int i = 1; i <= M; i++){
			st = new StringTokenizer(br.readLine());
			what = Integer.parseInt(st.nextToken());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			if(what == 0) {
				UnionParent(a, b);
			} else if(what == 1) {
				if(FindParent(a, b)) System.out.println("YES");
				else System.out.println("NO");
			}
		}
	}
	static boolean FindParent(int x, int y) {
		int a = getParent(x);
		int b = getParent(y);
		
		if(a == b) return true;
		else return false;
	}
	static void UnionParent(int x, int y) {
		int a = getParent(x);
		int b = getParent(y);
		
		if(a < b) parent[b] = a;
		else parent[a] = b;
	}
	static int getParent(int x) {
		if(parent[x] == x) return x;
		else return getParent(parent[x]);
	}
}
