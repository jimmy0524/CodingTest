class Solution {
    StringBuilder resultLeft = new StringBuilder();
    public String solution(int[] food) {
        for (int i = 1; i < food.length; i++) {
            for (int j = 0; j < food[i] / 2; j++) {
                resultLeft.append(i);
            }
        }
        String temp = resultLeft.toString();
        StringBuilder resultRight = new StringBuilder();
        resultRight.append(temp);
        resultRight.reverse();
        
        resultLeft.append(0);
        resultLeft.append(resultRight);
        return resultLeft.toString();
    }
}