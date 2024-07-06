package 정렬4.병합_정렬;

import java.util.Scanner;

public class sil5_2751 {
    public static int[] A;
    public static int[] tmp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        A = new int[N + 1];
        tmp = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            A[i] = sc.nextInt();
        }
        //병합 정렬
        merge(1, N);

        for (int i = 1; i <= N; i++) {
            System.out.println(A[i]);
        }
    }
    private static void merge(int a, int b) {
        if (b - a < 1) {
            return;
        }
        int mid = a + (b - a) / 2; //중간값 오버플로우 방지
        merge(a, mid);//왼쪽 정렬
        merge(mid + 1, b);//오른쪽 정렬
        for (int i = a; i <= b ; i++) {
            tmp[i] = A[i]; //정렬할 배열의 구간을 tmp에 임시 저장
        }
        int k = a; //시작 인덱스 (정렬할 위치)
        int index1 = a; //왼쪽 반의 시작 인덱스
        int index2 = mid + 1; //오른쪽 반의 시작 인덱스
        //정렬
        while (index1 <= mid && index2 <= b) {
            //왼쪽 반의 값이 크면 오른쪽의 값을 A배열에 넣기
            if (tmp[index1] > tmp[index2]) {
                A[k] = tmp[index2];
                k++;
                index2++;
            } else {
                A[k] = tmp[index1];
                k++;
                index1++;
            }
        }
        //왼쪽 반에 남아있는 요소를 A에 넣기
        while (index1 <= mid) {
            A[k] = tmp[index1];
            k++;
            index1++;
        }
        //오른쪽 반에 남아있는 요소를 B에 넣기
        while (index2 <= b) {
            A[k] = tmp[index2];
            k++;
            index2++;
        }
    }
}
