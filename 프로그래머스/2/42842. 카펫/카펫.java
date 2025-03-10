class Solution {
    public int[] solution(int brown, int yellow) {
        for (int i = 3; i <= (int) Math.sqrt(brown + yellow); i++) {
           if ((brown + yellow) % i == 0) {
               int j = (brown + yellow) / i;
               if ((i - 2) * (j - 2)  == yellow) {
                   return new int[]{j, i};
               }
           }
        }
        return new int[]{0};
    }
}