import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        PriorityQueue<Integer> asc = new PriorityQueue<>();
        PriorityQueue<Integer> desc = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < operations.length; i++) {
            String[] arr = new String[2];
            arr = operations[i].split(" ");
            if (arr[0].startsWith("I")) { //큐에 숫자 삽입
                asc.add(Integer.parseInt(arr[1]));
                desc.add(Integer.parseInt(arr[1]));
            } else { //D로 시작하는 것
                if (!asc.isEmpty()) {
                    if (arr[1].equals("-1")) { //최솟값 삭제
                        desc.remove(asc.poll());
                    } else { //1 최댓값 삭제
                        asc.remove(desc.poll());
                    }
                } 
             }
          }
        
        if (!asc.isEmpty()) {
            answer[1] = asc.peek();
            answer[0] = desc.peek();
        }
        
            
        return answer;
    }
}