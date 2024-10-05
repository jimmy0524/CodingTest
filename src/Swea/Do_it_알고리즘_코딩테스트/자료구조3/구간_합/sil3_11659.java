package Do_it_알고리즘_코딩테스트.자료구조3.구간_합;

import java.util.Scanner;

public class sil3_11659 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //데이터 개수
        int m = sc.nextInt(); //질의 개수
        int[] sum = new int[n + 1];
        //값 받음과 동시에 구간 합 구하기
        for(int i = 1; i <= n; i++){
            sum[i] = sum[i-1] + sc.nextInt();

        }
        for(int i = 0; i < m; i++){
            int a = sc.nextInt(); //ex)1
            int b = sc.nextInt(); //ex)3
            System.out.println(sum[b] - sum[a - 1]);
        }
    }
}
