import java.util.*;

class Solution {
    public int solution(String dartResult) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < dartResult.length(); i++) {
            if (dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9') { //숫자면
                if (dartResult.charAt(i) == '1' && dartResult.charAt(i + 1) == '0') {
                    arr.add(10);
                    i++;
                } else {
                    arr.add(dartResult.charAt(i) - '0');
                }
            } else {
                int lastIndex = arr.size() - 1;
                int lastValue = arr.get(lastIndex);
                switch(dartResult.charAt(i)) {
                    case 'D': 
                        arr.set(lastIndex, lastValue * lastValue);
                        break;
                    case 'T':
                        arr.set(lastIndex, lastValue * lastValue * lastValue);
                        break;
                    case '*':
                        if (arr.size() >= 2) {
                            int secondIndex = lastIndex - 1;
                            int secondValue = arr.get(secondIndex);
                            arr.set(secondIndex, secondValue * 2);
                        }
                        arr.set(lastIndex, lastValue * 2);
                        break;
                    case '#':
                        arr.set(lastIndex, lastValue * -1);
                        break;
                } 
            }
        }
        int answer = 0;
        return arr.stream().mapToInt(i -> i).sum();
    }
}