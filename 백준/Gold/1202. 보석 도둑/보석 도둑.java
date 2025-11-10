import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    // 가방을 작은 것부터 정렬
    // 보석을 무게 순으로 정렬
    // 가방 작은 것부터 순회하면서 넣을 수 있는 보석을 pq에 담기 (pq는 가치가 큰 것부터 작은 순으로 정렬)
    // 가방을 선택할 때마다 pq에서 가장 앞에 값을 answer+=
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보석의 수
        int K = Integer.parseInt(st.nextToken()); // 가방의 수
        int[] bags = new int[K];
        int[][] jewels = new int[N][2];
        long answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken()); // 무게
            int V = Integer.parseInt(st.nextToken()); // 가격
            jewels[i][0] = M;
            jewels[i][1] = V;
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            bags[i] = Integer.parseInt(st.nextToken()); // 가방의 최대 무게
        }

        //정렬
        Arrays.sort(bags);
        Arrays.sort(jewels, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int jewelIndex = 0;
        for (int i = 0; i < K; i++) {
            int limit = bags[i];
            for (int j = jewelIndex; j < N; j++) {
                if (jewels[j][0] <= limit) {
                    pq.add(jewels[j][1]);
                    jewelIndex++;
                } else {
                    break;
                }
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }


        System.out.println(answer);
    }
}

