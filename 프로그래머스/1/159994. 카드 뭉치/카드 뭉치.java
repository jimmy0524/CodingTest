class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        int index1 = 0;
        int index2 = 0;
        for (int i = 0; i < goal.length; i++) {
            boolean check = false;
            if (cards1[index1].equals(goal[i])) {
                check = true;
                if (i == goal.length - 1 && index1 == cards1.length - 1) {
                    // 문장의 마지막 문자면 
                    break;
                }
                
                if (index1 != cards1.length - 1) {
                    // 카드의 마지막 문자가 아닐떄
                   index1 ++;
                   continue;
                } 
            }
            
            if (cards2[index2].equals(goal[i])) {
                check = true;
                if (i == goal.length - 1 && index2 == cards2.length - 1) {
                    // 문장의 마지막 문자면 
                    break;
                }
                
                if (index2 != cards2.length - 1) {
                   index2 ++;
                   continue;
                }
            }
            if (!check) {
                return "No";
            }
        }
        return answer;
    }
}