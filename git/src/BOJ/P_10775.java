package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_10775 {
	static int G, P, cur, res = 0, visit[], parent[];
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		parent = new int[G+1];
		for(int i = 1; i <= G; i++) {
			parent[i] = -1;
		}
	}
	static int find(int n) {
		if(parent[n] < 0) return n;
		return parent[n] = find(parent[n]);
	}
	static void merge(int a, int b) {
		a = find(a);
		b = find(b);
		if(a == b) return;
		parent[b] += parent[a];
		if(a > b) parent[a] = b;
	}
}