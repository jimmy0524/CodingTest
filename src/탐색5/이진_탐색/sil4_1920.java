package 탐색5.이진_탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sil4_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); //데이터 개수
        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A); //A배열 정렬
        //이진 탐색
        boolean[] find = new boolean[M];
        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = N - 1;
            while (start <= end) {
                int mid = (start + end) / 2;
                //중간값 > 타겟값 -> 왼쪽 데이터셋 선택
                if (A[mid] > B[i]) {
                    end = mid - 1;
                } else if (A[mid] < B[i]) {
                    start = mid + 1;
                } else {
                    find[i] = true;
                    break;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            if (!find[i]) {
                System.out.println(0);
            } else {
                System.out.println(1);
            }
        }
    }
}
