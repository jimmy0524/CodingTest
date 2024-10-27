import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;

public class day21_1283 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<String> wordList = new ArrayList<>();
        HashSet<Character> clippedWordSet = new HashSet<>();

        for (int i = 0; i < N; i++) {
            wordList.add(br.readLine());
        }

        for (int i = 0; i < N; i++) {
            String[] split = wordList.get(i).split(" ");
            boolean isSet = false;

            for (int j = 0; j < split.length; j++) {
                //단어의 첫 번째 단어가 단축어가 될 때
                char firstChar = Character.toLowerCase(split[j].charAt(0));
                if (!clippedWordSet.contains(firstChar)) {
                    StringBuilder sb = new StringBuilder(split[j]);
                    sb.insert(0, '[');
                    sb.insert(2, ']');
                    split[j] = sb.toString();

                    clippedWordSet.add(firstChar);
                    isSet = true;
                    break;
                }
            }

            if (!isSet) {
                task:
                for (int j = 0; j < split.length; j++) {
                    for (int k = 1; k < split[j].length(); k++) {
                        char currentChar = Character.toLowerCase(split[j].charAt(k));
                        if (!clippedWordSet.contains(currentChar)) {
                            StringBuilder sb = new StringBuilder(split[j]);
                            sb.insert(k, '[');
                            sb.insert(k + 2, ']');
                            split[j] = sb.toString();

                            clippedWordSet.add(currentChar);
                            break task;
                        }
                    }
                }
            }
            wordList.set(i, String.join(" ", split));
        }

        for (String line : wordList) {
            System.out.println(line);
        }
    }
}
