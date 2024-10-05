package Do_it_알고리즘_코딩테스트.트리9.트라이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//트라이로 풀기
public class sil3_14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        tNode root = new tNode();

        while (N > 0) {
            String text = br.readLine();
            tNode now = root;
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);

                if (now.next[c - 'a'] == null) {
                    now.next[c - 'a'] = new tNode();
                }
                now = now.next[c - 'a'];
                if (i == text.length() - 1) {
                    now.isEnd = true;
                }
            }
            N--;
        }

        int count = 0;
        while (M > 0) {
            String text = br.readLine();
            tNode now = root;

            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (now.next[c - 'a'] == null) {
                    break;
                }
                now = now.next[c - 'a'];
                if (i == text.length() - 1 && now.isEnd) {
                    count++;
                }
            }
            M--;
        }
        System.out.println(count);
    }
    static class tNode {
        tNode[] next = new tNode[26];
        boolean isEnd;
    }
}

////hashset으로 풀기
//public class sil3_14425 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int N = Integer.parseInt(st.nextToken());
//        int M = Integer.parseInt(st.nextToken());
//        int count = 0;
//        Set<String> array = new HashSet<String>();
//
//        for (int i = 0; i < N; i++) {
//            array.add(br.readLine());
//        }
//
//        for (int i = 0; i < M; i++) {
//            String s = br.readLine();
//
//            if (array.contains(s)) {
//                count++;
//            }
//        }
//
//        System.out.println(count);
//    }
//}
