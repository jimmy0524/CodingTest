class Solution {
    public String solution(int[] numbers, String hand) {
        int[] left = {0,3};
        int[] right = {2,3};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            int[] temp = findKey(numbers[i]);
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                sb.append("L");
                left[0] = temp[0];
                left[1] = temp[1];
                continue;
            }
            if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                sb.append("R");
                right[0] = temp[0];
                right[1] = temp[1];
                continue;
            }
            
            int leftDistance = Math.abs(left[0] - temp[0]) + Math.abs(left[1] - temp[1]);
            int rightDistance = Math.abs(right[0] - temp[0]) + Math.abs(right[1] - temp[1]);
            
            if (rightDistance == leftDistance) {
                if (hand.equals("right")) {
                    sb.append("R");
                    right[0] = temp[0];
                    right[1] = temp[1];
                    continue;
                }
                sb.append("L");
                left[0] = temp[0];
                left[1] = temp[1];
                continue;
            } else if (rightDistance < leftDistance) {
                sb.append("R");
                right[0] = temp[0];
                right[1] = temp[1];
                continue;
            }
            sb.append("L");
            left[0] = temp[0];
            left[1] = temp[1];
            continue;
        }
        return sb.toString();
    }
    public int[] findKey(int n) {
        int[] temp = new int[2];
        switch (n) {
            case 1:
                temp = new int[]{0, 0};
                break;
            case 2:
                temp = new int[]{1, 0};
                break;
            case 3:
                temp = new int[]{2, 0};
                break;
            case 4:
                temp = new int[]{0, 1};
                break;
            case 5:
                temp = new int[]{1, 1};
                break;
            case 6:
                temp = new int[]{2, 1};
                break;    
            case 7:
                temp = new int[]{0, 2};
                break;    
            case 8:
                temp = new int[]{1, 2};
                break;
            case 9:
                temp = new int[]{2, 2};
                break;
            case 0:
                temp = new int[]{1, 3};
                break;
        }
        return temp;
    }
}