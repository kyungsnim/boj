package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_2884 {
	static int H, M;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		if(M < 45) {
			if(H == 0) H = 24;
			H -= 1;
			M += 15;
		} else {
			M -= 45;
		}
		
		System.out.println(H + " " + M);
	}
}
