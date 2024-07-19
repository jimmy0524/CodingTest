package 그리디6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sil2_1541 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split("-"); // - 기준으로 split 수행
        int[] temp = new int[str.length]; // + 기준으로 split 수행한 값 더한 배열
        for (int i = 0; i < str.length; i++) {
            int sum = 0;
            String[] str2 = str[i].split("[+]"); // + 기준으로 split 수행
            //정규 표현식에서 +는 특수 문자이므로, 문자열 리터럴로 사용하려면 "[+]"와 같이 대괄호로 묶어야 함
            for (int j = 0; j < str2.length; j++) {
                sum += Integer.parseInt(str2[j]);
            }
            temp[i] = sum;
        }
        int result = temp[0];
        for (int i = 1; i < str.length; i++) {
            result -= temp[i];
        }
        System.out.println(result);
    }
}
