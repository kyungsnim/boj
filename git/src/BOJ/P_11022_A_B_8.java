package BOJ;

import java.io.IOException;
import java.util.Scanner;

public class P_11022_A_B_8 {

	static int T, A, B;
	public static void main(String[] args) throws IOException{
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			A = sc.nextInt();
			B = sc.nextInt();
			System.out.println(A+B);
		}
		sc.close();
	}
}
