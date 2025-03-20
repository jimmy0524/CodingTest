class Solution {
    public String solution(int a, int b) {
        int[] dayLimit = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI","SAT","SUN","MON","TUE","WED","THU"};
        int days = 0;
        for (int i = 0; i < a - 1; i++) {
                days += dayLimit[i];
        }
        days += b - 1;
        
        return day[days % 7];
    }
}