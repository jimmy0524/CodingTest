class Solution {
    StringBuilder result = new StringBuilder();
    public String solution(int[] food) {
        for (int i = 1; i < food.length; i++) {
            result.append(Integer.toString(i).repeat(food[i] / 2));
        }
        String resultString = result.toString() + "0";
        
        return resultString + result.reverse();
    }
}