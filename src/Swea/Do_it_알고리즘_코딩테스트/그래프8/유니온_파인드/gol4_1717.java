package Do_it_알고리즘_코딩테스트.그래프8.유니온_파인드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class gol4_1717 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken()); //연산의 개수

        arr = new int[A+1];
        for (int i = 1; i <= A; i++) {
            arr[i] = i;
        }
        for (int i = 1; i <= B; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); //0인지 1인지 체크
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0) { //0이면 유니온
                union(b, c);
            } else { //같은 집합의 원소인지 확인
                if(checkSame(b, c)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        }
    }

    public static void union(int b, int c) {
        b = find(b);
        c = find(c);
        if(b != c) {
            arr[c] = b;
        }
    }

    public static int find(int a) {
        if(a == arr[a]) {
            return a;
        } else {
            return arr[a] = find(arr[a]);
        }
    }
    public static boolean checkSame(int b, int c) {
        if(find(b) == find(c)) {
            return true;
        }
        return false;
    }
}
