package 자료구조3.스택과_큐;

import java.util.Scanner;
import java.util.Stack;

public class sil3_1874 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int num = 1; //오름차순으로 스택에 들어갈 수
        boolean result = true;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++) {
            if(arr[i] >= num) {
                while(arr[i] >= num) {
                    stack.push(num++); //num 넣고 num 1 증가
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            }
            else { //arr[i] < num
                int k = stack.pop();
                if(arr[i] == k){
                    sb.append("-\n");
                    continue;
                }
                System.out.println("NO");
                result = false;
                break;
            }
        }
        if(result) {
            System.out.println(sb);
        }
    }
}
