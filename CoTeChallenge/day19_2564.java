import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day19_2564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int width = Integer.parseInt(st.nextToken()); //가로
        int height = Integer.parseInt(st.nextToken()); //세로
        int N = Integer.parseInt(br.readLine());
        int[][] stores = new int[N][2]; //입력 받은 값

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            stores[i][0] = Integer.parseInt(st.nextToken()); //방향
            stores[i][1] = Integer.parseInt(st.nextToken()); //거리
        }

        st = new StringTokenizer(br.readLine());
        int dongDir = Integer.parseInt(st.nextToken()); // 동근이의 방향
        int dongDist = Integer.parseInt(st.nextToken()); // 동근이의 거리

        int ans = 0;
        for (int i = 0; i < N; i++) {
            int storeDir = stores[i][0];
            int storeDist = stores[i][1];
            // 같은 방향일 때
            if (dongDir == storeDir) {
                ans += Math.abs(dongDist - storeDist);
            } else if ((dongDir == 1 && storeDir == 2) || (dongDir == 2 && storeDir == 1)) {
                // 북남으로 마주볼 때
                ans += Math.min(dongDist + storeDist, (width - dongDist) + (width - storeDist)) + height;
            } else if ((dongDir == 3 && storeDir == 4) || (dongDir == 4 && storeDir == 3)) {
                // 서동으로 마주볼 때
                ans += Math.min(dongDist + storeDist, (height - dongDist) + (height - storeDist)) + width;
            } else {
                // 직교 방향일 때 (북-서, 북-동, 남-서, 남-동)
                switch (dongDir) {
                    case 1: // 북쪽
                        ans += (storeDir == 3) ? dongDist + storeDist : (width - dongDist) + storeDist;
                        break;
                    case 2: // 남쪽
                        ans += (storeDir == 3) ? dongDist + (height - storeDist) : (width - dongDist) + (height - storeDist);
                        break;
                    case 3: // 서쪽
                        ans += (storeDir == 1) ? dongDist + storeDist : (height - dongDist) + storeDist;
                        break;
                    case 4: // 동쪽
                        ans += (storeDir == 1) ? (width - storeDist) + dongDist : (height - dongDist) + (width - storeDist);
                        break;
                }
            }
        }
        System.out.println(ans);
    }
}
