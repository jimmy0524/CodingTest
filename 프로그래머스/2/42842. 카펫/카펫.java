class Solution {
    public int[] solution(int brown, int yellow) {
        int weight = 0;
        int height = 0;
        for (int i = 3; i < brown + yellow; i++) {
           if ((brown + yellow) % i == 0) {
               int j = (brown + yellow) / i;
               if ((i - 2) * (j - 2)  == yellow) {
                   if (i > j) {
                       weight = i;
                       height = j;
                   }
                   height = i;
                   weight = j;
                   break;
               }
               
           }
        }
        return new int[]{weight, height};
    }
}