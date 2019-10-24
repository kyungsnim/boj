package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P_1152 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int cnt = 0;
			
		if(st.countTokens() == 0) System.out.println(cnt);
		else {
			while(true) {
				String tmp = st.nextToken();
				cnt++;
				if(st.countTokens() == 0) {
					System.out.println(cnt);
					break;
				}
			}
		}
		
	}

}
