import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); //도시의 수
        int M = Integer.parseInt(br.readLine()); //여행 계획에 속한 도시의 수
        int[][] city = new int[N + 1][N + 1];
        arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                city[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //도시가 연결돼 있으면 union
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (city[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        int[] ans = new int[M + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= M; i++) {
            ans[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 2; i <= M; i++) {
            if (find(arr[ans[i]]) != find(arr[ans[i - 1]])) { //find해줘야 경로 압축 즉 하나의 대표 노드로 나타낼 수 있다
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static void union(int i, int j) {
        i = find(i);
        j = find(j);
        if (i != j) {
            arr[j] = i;
        }
    }

    public static int find(int a) {
        if (arr[a] == a) {
            return a;
        } else {
            return arr[a] = find(arr[a]);
        }
    }
}
