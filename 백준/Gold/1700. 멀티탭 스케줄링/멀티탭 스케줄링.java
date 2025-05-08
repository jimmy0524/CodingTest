import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		HashSet<Integer> set = new HashSet<>();
		ArrayList<Integer> list = new ArrayList<>();
		int answer = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		for (int i = 0; i < K; i++) {
			int now = list.get(i);
			if (set.contains(now)) {
				continue;
			}
			if (set.size() < N) {
				set.add(now);
				continue;
			}
			HashMap<Integer, Integer> map = new HashMap<>();
			for (int s : set) {
				boolean check = false;
				for (int j = i + 1; j < K; j++) {
					if (s == list.get(j)) {
						check = true;
						map.put(s, map.getOrDefault(s, j));
					}
				}
				if (!check) {
				   map.put(s, 101);
				}
			}
			List<Integer> keySet = new ArrayList<>(map.keySet());
			keySet.sort((a, b) -> map.get(b) - map.get(a));
			set.remove(keySet.get(0));
			set.add(now);
			answer++;
		}
		System.out.println(answer);
	}
}
