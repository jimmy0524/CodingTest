package Do_it_알고리즘_코딩테스트.그리디6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class sil1_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] A = new int[N + 1][2]; //몇번째 0, 1 로 0 : 시작시간, 1 : 종료시간

        for (int i = 1; i < N + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            A[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }
        //정렬
        Arrays.sort(A, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0]; // 종류 시간이 같으면 시작 시간 빠른 순으로 정렬
                }
                else {
                    return o1[1] - o2[1]; // 보통은 종료 시간 기준으로 정렬
                }
            }
        });

        int count = 1; // 첫번째는 무조건 들어간다고 가정
        int temp = A[1][1]; // 가장 첫번째 수의 종료시간 넣음
        for (int i = 2; i < N + 1; i++) {
            //확정된 회의의 종료시간보다 다음 회의 후보의 시작시간이 크거나 같으면 !
            if (A[i][0] >= temp) {
                count ++;
                temp = A[i][1]; // 종료시간 갱신
            }
        }
        System.out.println(count);
    }
}
