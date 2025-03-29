class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length - 1; i++) {
            boolean check = false;
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j - i;
                    check = true;
                    break;
                }
            }
            if (!check) {
                answer[i] = prices.length - 1 - i;
            }
        }
        answer[prices.length - 1] = 0;
        
        return answer;
    }
}