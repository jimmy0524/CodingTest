import java.io.*;
import java.util.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String type = st.nextToken();
            if (type.equals("push")) {
                s.push(Integer.valueOf(st.nextToken()));
                continue;
            }
            if (type.equals("top")) {
                if (s.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(s.peek());
                }
                continue;
            }
            if (type.equals("size")) {
                System.out.println(s.size());
                continue;
            }
            if (type.equals("empty")) {
                if (s.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
                continue;
            }
            if (type.equals("pop")) {
                if (s.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(s.pop());
                }
            }

        }
    }
}