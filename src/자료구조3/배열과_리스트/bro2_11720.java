package 자료구조3.배열과_리스트;

import java.util.Scanner;
public class bro2_11720 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String str = sc.next();
        int sum = 0;
        char[] strArr = str.toCharArray();

        for(int i = 0; i < n; i++){
            sum += strArr[i] - '0';
        }
        System.out.println(sum);
    }
}