class Solution {
    public String solution(String phone_number) { 
        StringBuilder sb = new StringBuilder();
        int starLength = phone_number.length() - 4;
        for (int i = 0; i < starLength; i++) {
            sb.append("*");
        }
        for (int i = starLength; i < phone_number.length(); i++) {
            sb.append(phone_number.charAt(i));
        }
        return sb.toString();
    }
}