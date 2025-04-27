import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < privacies.length; i++) {
            String[] temp = privacies[i].split(" ");
            for (int j = 0; j < terms.length; j++) {
                if (String.valueOf(terms[j].charAt(0)).equals(temp[1])) {
                    String[] term = terms[j].split(" ");
                    String[] date = temp[0].split("\\.");
                    int sum = Integer.valueOf(date[1]) + Integer.valueOf(term[1]);
                    int addYear = sum / 12;
                    int newMonth = sum % 12;
                    if (newMonth == 0) {
                        newMonth = 12;
                        addYear -= 1;
                    }
                    String[] todayDate = today.split("\\.");
                    int newYear = Integer.valueOf(date[0]) + addYear;
                    if (Integer.valueOf(todayDate[0]) > newYear) {
                        result.add(i + 1);
                        break;
                    } else if (Integer.valueOf(todayDate[0]) == newYear) {
                        if (Integer.valueOf(todayDate[1]) > newMonth) {
                            result.add(i + 1);
                            break;
                        } else if (Integer.valueOf(todayDate[1]) == newMonth) {
                            if (Integer.valueOf(todayDate[2]) >= Integer.valueOf(date[2])) {
                                result.add(i + 1);
                                break;
                        }
                    }
                }
            }
        }
    }
        return result.stream().mapToInt(i -> i).toArray();
}
}