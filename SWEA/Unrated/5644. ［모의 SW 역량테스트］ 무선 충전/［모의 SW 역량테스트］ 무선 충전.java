/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.*;
import java.util.*;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
    static int M, A;
    static int[] moveA, moveB;
    static int totalCharge;
    static List<Integer>[][] cover;
    static BC[] bcs;

    // 0: 제자리, 1: 상, 2: 우, 3: 하, 4: 좌
    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};
    
	public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            moveA = new int[M+1];
            moveB = new int[M+1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) moveA[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= M; i++) moveB[i] = Integer.parseInt(st.nextToken());

            bcs = new BC[A];
            for (int i = 0; i < A; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                bcs[i] = new BC(x, y, c, p);
            }

            // 전처리
            preprocess();

            totalCharge = 0;

            int Ax = 1, Ay = 1;
            int Bx = 10, By = 10;

            for (int t = 0; t <= M; t++) {
                totalCharge += getMaxCharge(Ax, Ay, Bx, By);

                if (t < M) {
                    Ax += dx[moveA[t+1]];
                    Ay += dy[moveA[t+1]];
                    Bx += dx[moveB[t+1]];
                    By += dy[moveB[t+1]];
                }
            }

            sb.append("#").append(tc).append(" ").append(totalCharge).append("\n");
        }
        System.out.print(sb.toString());
    }

    static void preprocess() {
        cover = new ArrayList[11][11];
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                cover[i][j] = new ArrayList<>();
            }
        }

        for (int idx = 0; idx < A; idx++) {
            BC bc = bcs[idx];
            for (int x = 1; x <= 10; x++) {
                for (int y = 1; y <= 10; y++) {
                    if (Math.abs(bc.x - x) + Math.abs(bc.y - y) <= bc.c) {
                        cover[x][y].add(idx);
                    }
                }
            }
        }
    }

    static int getMaxCharge(int Ax, int Ay, int Bx, int By) {
        int max = 0;
        for (int a : cover[Ax][Ay]) {
            for (int b : cover[Bx][By]) {
                int sum;
                if (a == b) sum = bcs[a].p;
                else sum = bcs[a].p + bcs[b].p;
                max = Math.max(max, sum);
            }
        }

        // A만 충전
        for (int a : cover[Ax][Ay]) {
            max = Math.max(max, bcs[a].p);
        }
        // B만 충전
        for (int b : cover[Bx][By]) {
            max = Math.max(max, bcs[b].p);
        }
        return max;
    }

    static class BC {
        int x, y, c, p;
        public BC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }
}