class Solution {
    public String solution(int[] numbers, String hand) {
        int[][] keypad = {
            {1,3}, //0
            {0,0}, //1
            {1,0}, //2
            {2,0}, //3
            {0,1}, //4
            {1,1}, //5
            {2,1}, //6
            {0,2}, //7
            {1,2}, //8
            {2,2}  //9
    };
        int[] left = {0,3};
        int[] right = {2,3};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                left = keypad[numbers[i]].clone();
                continue;
            }
            if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                right = keypad[numbers[i]].clone();
                continue;
            }
            
            int leftDistance = Math.abs(left[0] - keypad[numbers[i]][0]) + Math.abs(left[1] - keypad[numbers[i]][1]);
            int rightDistance = Math.abs(right[0] - keypad[numbers[i]][0]) + Math.abs(right[1] - keypad[numbers[i]][1]);
            
            if (rightDistance == leftDistance) {
                if (hand.equals("right")) {
                    sb.append("R");
                    right = keypad[numbers[i]].clone();
                    continue;
                }
                sb.append("L");
                left = keypad[numbers[i]].clone();
                continue;
            } else if (rightDistance < leftDistance) {
                sb.append("R");
                right = keypad[numbers[i]].clone();
                continue;
            }
            sb.append("L");
            left = keypad[numbers[i]].clone();
            continue;
        }
        return sb.toString();
    }
}