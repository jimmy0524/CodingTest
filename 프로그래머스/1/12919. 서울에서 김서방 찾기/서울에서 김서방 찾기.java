class Solution {
    public String solution(String[] seoul) {
        StringBuilder sb = new StringBuilder();
        sb.append("김서방은 ");
        for (int i = 0; i < seoul.length; i++) {
            if (seoul[i].equals("Kim")) {
                sb.append(i + "에 있다");
                break;
            }
        }
        String answer = sb.toString();
        return answer;
    }
}