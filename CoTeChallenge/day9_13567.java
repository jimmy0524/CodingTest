import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class day9_13567 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken()); // M * M 정사각형
        int n = Integer.parseInt(st.nextToken()); //명령어 개수
        //현재위치
        int nowX = 0;
        int nowY = 0;
        //우,상,좌,하 (시계 반대)
        int[] DR = {0, -1, 0, 1}; //행
        int[] DC = {1, 0, -1, 0}; //열
        int dir = 0; //방향 (처음엔 오른쪽으로)
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken(); //명령어
            int num = Integer.parseInt(st.nextToken()); //얼만큼 or 무슨방향으로
            if (command.equals("MOVE")) {
                nowX += DC[dir] * num;
                nowY += DR[dir] * num;
                if (nowX < 0 || nowY > 0 || nowX > M || nowY < -M) {
                    System.out.println(-1);
                    return;
                }
            } else {
                if (num == 0) {
                    dir = (dir + 1) % 4;
                } else {
                    dir = (4 + (dir - 1)) % 4;
                }
            }
        }
        System.out.println(nowX + " " + -1 * nowY);
    }
}

