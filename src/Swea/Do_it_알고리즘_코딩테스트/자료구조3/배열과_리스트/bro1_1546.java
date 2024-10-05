package Do_it_알고리즘_코딩테스트.자료구조3.배열과_리스트;

import java.util.Scanner;

public class bro1_1546 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        double sum = 0;
        long max = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = scanner.nextInt();
        }
        for(int i = 0; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        for(int i = 0; i < n; i++){
            sum += (double) arr[i] / max * 100;
        }
        System.out.println(sum/n);

    }
}
