import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Flower[] flowers = new Flower[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int startMonth = Integer.parseInt(st.nextToken());
			int startDay = Integer.parseInt(st.nextToken());
			int endMonth = Integer.parseInt(st.nextToken());
			int endDay = Integer.parseInt(st.nextToken());
			
			int start = startMonth * 100 + startDay;
			int end = endMonth * 100 + endDay;
			flowers[i] = new Flower(start, end);
		}
		Arrays.sort(flowers, (a, b) -> {
			if (a == b) {
				return b.end - a.end; 
			}
			return a.start - b.start;
		});
		
		int start = 301;
		int end = 1130;
		int answer = 0;
		int tempEnd = 0;
		int idx = 0;
		
		for (int i = 0; i < N; i++) {
			Flower f = flowers[i];
			if (f.start <= start) {
				if (f.end > tempEnd) {
					idx = i;
					tempEnd = f.end;
				}
			}
		}
		
		if (tempEnd == 0) {
			System.out.println(0);
			return;
		} else {
			answer++;
		}
		
		if (tempEnd > end) {
			System.out.println(1);
			return;
		}
		
		while (true) {
			boolean check = false;
			int temp = tempEnd;
			for (int i = idx + 1; i < N; i++) {
				if (flowers[i].start <= temp) {
					if (flowers[i].end > tempEnd) {
						idx = i;
						check = true;
						tempEnd = flowers[i].end;
					}
				} else {
					break;
				}
			}
			if (!check) {
				System.out.println(0);
				return;
			}
			
			answer++;
			
			if (tempEnd > end) {
				break;
			}
		}
		
		System.out.println(answer);
	}
	
	public static class Flower {
		int start, end;
		
		public Flower(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
