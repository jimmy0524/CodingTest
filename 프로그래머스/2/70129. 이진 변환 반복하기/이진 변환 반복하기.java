class Solution {
    public int[] solution(String s) {
        int zero = 0;
        int count = 0;
        
        while (!s.equals("1")) {
            int beforeLength = s.length();
            s = s.replace("0", "");
            int afterLength = s.length();
            zero += (beforeLength - afterLength);
            count ++;
            s = Integer.toBinaryString(afterLength);
        }
        
        return new int[]{count, zero};
    }
}