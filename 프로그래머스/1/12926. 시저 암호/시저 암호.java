class Solution {
    public String solution(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isUpperCase(s.charAt(i))) {
                sb.append((char)((s.charAt(i) - 'A' + n) % 26 + 'A'));
            } else if (Character.isLowerCase(s.charAt(i))) {
                sb.append((char)((s.charAt(i) - 'a' + n) % 26 + 'a'));
            } else {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}