class Solution {
    public double solution(int[] arr) {
        double sum = 0;
        for (int a : arr) {
            sum += a;
        }
        double answer = sum / arr.length;
        
        return answer;
    }
}