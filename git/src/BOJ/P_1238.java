package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P_1238 {
	static int N, M, X;
	static long D1[], D2[], D_res[];
	static ArrayList<Integer> con[], conv[];
	static PriorityQueue<long[]> pq = new PriorityQueue<long[]>(10, new Comparator<long[]>() {
		@Override
		public int compare(long[] o1, long[] o2) {
			return (int)(o1[0]-o2[0]);
		}
	});
	public static void main(String[] args) throws IOException {
		
		// N명의 학생
		// M개의 단바향 도로
		// X번째 마을
		// 4 8 2
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		con = new ArrayList[N+1];
		conv = new ArrayList[N+1];
		D1 = new long[N+1];
		D2 = new long[N+1];
		D_res = new long[N+1];
		
		for(int i = 1; i <= N; i++) {
			con[i] = new ArrayList<>();
			conv[i] = new ArrayList<>();
			D1[i] = Long.MAX_VALUE;
			D2[i] = Long.MAX_VALUE;
			D_res[i] = 0;
		}
		
		int x, y, z;
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			z = Integer.parseInt(st.nextToken());
			
			con[x].add(y);
			conv[x].add(z);
		}
		
		for(int i = 1; i <= N; i++) {
			dijkstra1(i);
			D_res[i] += D1[X];
		}
		dijkstra2(X);
		
		long max = 0;
		for(int i = 1; i <= N; i++) {
			if(i == X) {
				continue;
			} else {
				D_res[i] += D2[i];
			}
			
			if(max < D_res[i]) {
				max = D_res[i];
			}
		}
		
		System.out.println(max);
		// pq.add(new long[]{D[A][0], A});
		// pq.add(new long[]{D[B][0], B});
	}
	static void dijkstra1(int s) {
		for(int i = 1; i <= N; i++) {
			D1[i] = Long.MAX_VALUE;
		}
		
		D1[s] = 0;
		
		pq.add(new long[] {D1[s], s});
		
		while(!pq.isEmpty()) {
			int q = (int)pq.peek()[1];
			long d = pq.peek()[0];
			pq.poll();
			
			for(int i = 0; i < con[q].size(); i++) {
				int t = con[q].get(i);
				int v = conv[q].get(i);
				
				if(D1[t] > D1[q] + v) {
					D1[t] = D1[q] + v;
					
					pq.add(new long[] {D1[t], t});
				}
			}
		}
	}
	static void dijkstra2(int x) {
		D2[x] = 0;
		
		pq.add(new long[] {D1[x], x});
		
		while(!pq.isEmpty()) {
			int q = (int)pq.peek()[1];
			long d = pq.peek()[0];
			pq.poll();
			
			for(int i = 0; i < con[q].size(); i++) {
				int t = con[q].get(i);
				int v = conv[q].get(i);
				
				if(D2[t] > D2[q] + v) {
					D2[t] = D2[q] + v;
					
					pq.add(new long[] {D2[t], t});
				}
			}
		}
	}
}
