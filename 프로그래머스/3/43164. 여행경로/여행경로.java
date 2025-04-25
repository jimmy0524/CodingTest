import java.util.*;

class Solution {
    boolean[] visited;
    List<String> answer = new ArrayList<>();
    String[][] tickets;
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        visited = new boolean[tickets.length];
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        
        dfs("ICN", 0, new StringBuilder());
        
        return answer.get(0).split(" ");
    }
    public void dfs(String s, int depth, StringBuilder sb) {
        if (sb.length() < 1) {
            sb.append(s + " ");
        }
        if (depth == tickets.length) {
            if (answer.isEmpty()) {
                answer.add(sb.toString());
            }
            return;
        }
        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(s)) {
                visited[i] = true;
                int tempLength = sb.length();
                sb.append(tickets[i][1] + " ");
                dfs(tickets[i][1], depth + 1, sb);
                sb.setLength(tempLength);  
                visited[i] = false;
            }
        }
    }
}