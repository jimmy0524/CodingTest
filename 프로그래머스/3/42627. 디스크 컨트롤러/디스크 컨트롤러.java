import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[1];
            } else {
                return a[1] - b[1];
            }
        });
        
        int sum = 0;
        int time = 0;
        int idx = 0; //다음에 들어올 작업 인덱스
        int count = 0; //처리한 작업 수
        while (count < jobs.length) {
            while (idx < jobs.length && jobs[idx][0] <= time) {
                pq.add(jobs[idx]);
                idx++;
            }
            
            if (!pq.isEmpty()) {
                int[] now = pq.poll();
                time += now[1];
                sum += (time - now[0]); // 종료시간 - 요청시간
                count++;
            } else {
                // 현재 도착한 작업이 없으면 시간을 다음 작업 요청 시각으로 이동
                time = jobs[idx][0];
            }
        }
        return sum / jobs.length;
    }
}