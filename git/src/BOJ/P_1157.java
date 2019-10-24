package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P_1157 {
	static int ch[] = new int[26];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
				ch[str.charAt(i) - 'a']++;
			} else {
				ch[str.charAt(i) - 'A']++;
			}
		}
		int max = 0;
		int cnt = 0;
		int max_index = 0;
		for(int i = 0; i < 26; i++) {
			if(max < ch[i]) {
				max = ch[i];
				max_index = i;
				cnt = 0;
			} else if(max != 0 && max == ch[i]) {
				cnt++;
			}
		}
		if(cnt >= 1) {
			System.out.println("?");
		} else {
			System.out.println((char)('A'+max_index));
		}
		
	}

}
