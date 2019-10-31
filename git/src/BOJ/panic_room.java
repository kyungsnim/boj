package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class panic_room {
    static int T, N, M, a[][], d[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            a = new int[N+1][M+1];
            d = new int[N+1][M+1];
            
            for(int i = 1; i <= N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 1; j <= M; j++){
                    a[i][j] = Integer.parseInt(st.nextToken());
                    if(i == 1 && j == 1) {
                        d[i][j] = a[i][j];
                    } else if(i == 1 && j > 1) {
                        d[i][j] = d[i][j-1] + a[i][j];
                    } else if(i > 1 && j == 1){
                        d[i][j] = d[i-1][j] + a[i][j];
                    }
                }
            }

            for(int i = 2; i <= N; i++){
                for(int j = 2; j <= M; j++){
                        d[i][j] = Math.min(d[i][j-1] + a[i][j], d[i-1][j] + a[i][j]);
                }
            }
            System.out.println("#" + tc + " " + d[N][M]);
        }
    }
}