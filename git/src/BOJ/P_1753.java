package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P_1753 {

	static int V, E, K, u, v, w;
	static long[][] D;
	static ArrayList<Integer> con[], conv[];
	static PriorityQueue<long[]> pq = new PriorityQueue<long[]>(10, new Comparator<long[]>() {

		@Override
		public int compare(long[] o1, long[] o2) {
			// TODO Auto-generated method stub
			return (int)(o1[0]-o2[0]);
		}
	});
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		
		con = new ArrayList[V+1];
		conv = new ArrayList[V+1];
		D = new long[V+1][2];
		
		for(int i=1; i<=V; i++) {
			con[i] = new ArrayList<Integer>();
			conv[i] = new ArrayList<Integer>();
			D[i][0] = Long.MAX_VALUE;
		}
		
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			
			u = Integer.parseInt(st.nextToken());
			v = Integer.parseInt(st.nextToken());
			w = Integer.parseInt(st.nextToken());
			
			con[u].add(v);
			conv[u].add(w);
		}
		
		
		Dijkstra(K);
		for(int i=1; i<=V; i++){
			if(D[i][0]==Long.MAX_VALUE) {
				System.out.println("INF");
			}else {
				System.out.println(D[i][0]);
			}
		}
		
	}
	
	static void Dijkstra(int s) {
		
		D[s][0] = 0;
		D[s][1] = s;
		pq.add(new long[]{D[s][0], s});
	
		while (!pq.isEmpty()) {
			int q = (int)pq.peek()[1];
			long d = pq.peek()[0];
			
			pq.poll();
			
			if(d != D[q][0]) continue;
			
			for(int i=0; i<con[q].size(); i++) {
				
				int t = con[q].get(i);
				int v = conv[q].get(i);
				
				if(D[t][0] > D[q][0] + v && D[q][0] != Long.MAX_VALUE) {
					D[t][0] = D[q][0]+v;
					pq.add(new long[] {D[t][0], t});
				}
			}
		}
	}
	
	

}
