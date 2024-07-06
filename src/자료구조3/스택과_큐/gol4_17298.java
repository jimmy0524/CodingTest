package 자료구조3.스택과_큐;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class gol4_17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] ans = new int[N];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        //스택에 아무것도 없으니 처음 인덱스 넣어주기
        stack.push(0);
        
        for (int i = 1; i < N; i++) {
            //다음 배열의 수와 현재 stack의 top이 가리키는 배열의 값과 비교해서 다음 배열의 수가 더 크면 다음 배열의 index값 정답 배열에 추가, 저장되어있던 stack top 값 pop, 다음 배열의 index push
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                ans[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        //스택에 남아있는 인덱스에 -1 넣음
        while (!stack.isEmpty()) {
            ans[stack.pop()] = -1;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //정답 배열 출력
        for (int i = 0; i < N; i++) {
            bw.write(ans[i] + " ");
        }
        bw.flush();
    }
}
