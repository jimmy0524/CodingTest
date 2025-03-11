class Solution {
    StringBuilder result = new StringBuilder();
    public int solution(String s) {
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                result.append(s.charAt(i));
                continue;
            }
            temp += s.charAt(i);
            switch (temp) {
                case "zero": 
                    result.append("0");
                    temp = "";
                    break;
                case "one":
                    result.append("1");
                    temp = "";
                    break;
                case "two":
                    result.append("2");
                    temp = "";
                    break;
                case "three":
                    result.append("3");
                    temp = "";
                    break;
                case "four":
                    result.append("4");
                    temp = "";
                    break;
                case "five":
                    result.append("5");
                    temp = "";
                    break;
                case "six":
                    result.append("6");
                    temp = "";
                    break;
                case "seven":
                    result.append("7");
                    temp = "";
                    break;
                case "eight":
                    result.append("8");
                    temp = "";
                    break;
                case "nine":
                    result.append("9");
                    temp = "";
                    break;
            }
        }
        return Integer.parseInt(result.toString());
    }
}