package Do_it_알고리즘_코딩테스트.자료구조3.스택과_큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class sil1_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int A = Math.abs(o1);
            int B = Math.abs(o2);
            if(A == B) {
                return o1 > o2 ? 1 : -1;
            }
            else{
                return A - B;
            }
        });
        for (int i = 0; i < N; i++) {
            int request = Integer.parseInt(br.readLine());
            if(request == 0) {
                if(pq.isEmpty()){
                    System.out.println("0");
                }
                else {
                    System.out.println(pq.poll());
                }
            }
            else {
                pq.add(request);
            }
        }
    }
}
