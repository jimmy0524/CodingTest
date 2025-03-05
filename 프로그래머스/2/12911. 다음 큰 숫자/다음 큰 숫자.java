class Solution {
    public int solution(int n) {
        int countA = Integer.toBinaryString(n).replace("0", "").length(); //1의 개수
        
        while(true) {
            n++;
            int countB = Integer.toBinaryString(n).replace("0", "").length();
            if (countA == countB) {
                return n;
            }
        }
    }
}