class Solution {
    public int solution(String s) {
        char x = 'A';
        int sameCount = 0;
        int diffCount = 0;
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (x != 'A') {
                if (x == s.charAt(i)) {
                    sameCount++;
                } else {
                    diffCount++;
                }
                
            } else {
                x = s.charAt(i);
                sameCount++;
            }
            
            if (sameCount == diffCount) {
                x = 'A';
                sameCount = 0;
                diffCount = 0;
                answer++;
                continue;
            }
            
            if (i == s.length() - 1) {
                answer++;
            }
        }
        
        return answer;
    }
}