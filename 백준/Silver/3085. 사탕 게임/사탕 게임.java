import java.util.*;
import java.io.*;

public class Main {
	static int answer = 1;
	static int N;
	static char[][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			for (int j = 0; j < N; j++) {
				char c = s.charAt(j);
				arr[i][j] = c;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] != arr[i][j + 1]) {
					char temp = arr[i][j + 1];
					arr[i][j + 1] = arr[i][j];
					arr[i][j] = temp;
					search();
					//되돌리기
					arr[i][j] = arr[i][j + 1];
					arr[i][j + 1] = temp;
				}
			}
		} 
		
		if (answer == N) {
			System.out.println(N);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N - 1; j++) {
				if (arr[j][i] != arr[j + 1][i]) {
					char temp = arr[j + 1][i];
					arr[j + 1][i] = arr[j][i];
					arr[j][i] = temp;
					search();
					//되돌리기
					arr[j][i] = arr[j + 1][i];
					arr[j + 1][i] = temp;
				}
			}
		} 
		System.out.println(answer);
	}
	
	public static void search() {
		for (int i = 0; i < N; i++) {
			int count1 = 1;
			int count2 = 1;
			for (int j = 0; j < N - 1; j++) {
				if (arr[i][j] != arr[i][j + 1]) {
					count1 = 1;
				} else {
					count1++;
					answer = Math.max(answer, count1);
				}
				if (arr[j][i] != arr[j + 1][i]) {
					count2 = 1;
				} else {
					count2++;
					answer = Math.max(answer, count2);
				}
			}
		} 
	}
}
