package Do_it_알고리즘_코딩테스트.자료구조3.스택과_큐;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class sil4_2164 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); //카드의 개수
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
        while(queue.size() > 1) {
            queue.poll();
            int k = queue.poll();
            queue.add(k);
        }
        System.out.println(queue.poll());
    }
}
