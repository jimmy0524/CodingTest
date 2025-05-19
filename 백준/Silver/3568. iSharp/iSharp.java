import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		String first = arr[0];
		if (arr.length == 1) {
			return;
		}
		arr[arr.length - 1] = arr[arr.length - 1].substring(0, arr[arr.length - 1].length() - 1); //;제거
		for (int i = 1; i < arr.length - 1; i++) {
			arr[i] = arr[i].substring(0, arr[i].length() - 1); //,제거
		}
		for (int i = 1; i < arr.length; i++) {
			int index = 0;
			for (int j = 0; j < arr[i].length(); j++) {
				char temp = arr[i].charAt(j);
				if (!Character.isAlphabetic(temp)) {
					index = j;
					break;
				}
			}
			if (index == 0) {
				System.out.println(first + " " + arr[i] + ";");
				continue;
			}
			String left = arr[i].substring(0, index);
			String right = arr[i].substring(index);
			StringBuilder sb = new StringBuilder();
			sb.append(first);
			
			for (int j = right.length() - 1; j >= 0; j--) {
				if (right.charAt(j) == '[') {
					sb.append(']');
					continue;
				}
				if (right.charAt(j) == ']') {
					sb.append('[');
					continue;
				}
				sb.append(right.charAt(j));
			}
			
			sb.append(" ");
			sb.append(left);
			sb.append(";");
			System.out.println(sb.toString());
		}
		
	}
}
