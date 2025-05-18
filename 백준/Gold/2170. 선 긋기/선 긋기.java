import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Line[] lines = new Line[N];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			lines[i] = new Line(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(lines, (a,b) -> a.start - b.start);
		int end = lines[0].end;
		int sum = lines[0].end - lines[0].start;
		for (int i = 1; i < N; i++) {
			Line now = lines[i];
			if (now.end <= end) {
				continue;
			}
			if (now.start > end) {
				sum += now.end - now.start;
				end = now.end;
				continue;
			}
			sum += now.end - now.start - (end - now.start);
			end = now.end;
		}
		
		System.out.println(sum);
	}
	
	public static class Line {
		int start, end;
		public Line(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
}
