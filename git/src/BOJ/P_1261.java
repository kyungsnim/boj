package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P_1261 {
	static int N, M, arr[][];
	static long D[];
	static ArrayList<Integer> con[], conv[];
	static PriorityQueue<long[]> pq = new PriorityQueue<long[]>(10, new Comparator<long[]>() {
		@Override
		public int compare(long[] o1, long[] o2) {
			return (int)(o1[0]-o2[0]);
		}
	});
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		arr = new int[N+1][M+1];
		
		for(int i = 1; i <= N; i++) {
			String str = br.readLine();
			for(int j = 1; j <= str.length(); j++) {
				if(str.charAt(j-1) == '0') {
					arr[i][j] = 0;
				} else if(str.charAt(j-1) == '1') {
					arr[i][j] = 1;
				}
			}
		}
		
		// con, conv
		con = new ArrayList[N*M+1];
		conv = new ArrayList[N*M+1];
		D = new long[N*M+1];
		
		for(int i = 1; i <= N*M; i++) {
			con[i] = new ArrayList<>();
			conv[i] = new ArrayList<>();
			D[i] = Long.MAX_VALUE;
		}
		
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= M; j++) {
				if(i > 1) { // ��
					con[(i-1)*M+j].add((i-2)*M+j);
					conv[(i-1)*M+j].add(arr[i-1][j]);
				}
				if(i < N) { // ��
					con[(i-1)*M+j].add((i)*M+j);
					conv[(i-1)*M+j].add(arr[i+1][j]);
				}
				if(j > 1) { // ��
					con[(i-1)*M+j].add((i-1)*M+(j-1));
					conv[(i-1)*M+j].add(arr[i][j-1]);
				}
				if(j < M) { // ��
					con[(i-1)*M+j].add((i-1)*M+(j+1));
					conv[(i-1)*M+j].add(arr[i][j+1]);
				}
			}
		}
		dijkstra();
		// 4*4 -> 16
		System.out.println(D[N*M]);
	}
	static void dijkstra() {
		D[1] = 0;
		
		pq.add(new long[] {D[1], 1});
		
		while(!pq.isEmpty()) {
			int q = (int)pq.peek()[1];
			long d = pq.peek()[0];
			pq.poll();
			
			if(D[q] != d) continue;
			for(int i = 0; i < con[q].size(); i++) {
				int t = con[q].get(i);
				int v = conv[q].get(i);
				
				if(D[t] > D[q] + v && D[q] != Long.MAX_VALUE) {
					D[t] = D[q] + v;
					
					pq.add(new long[] {D[t], t});
				}
			}
		}
	}
}
