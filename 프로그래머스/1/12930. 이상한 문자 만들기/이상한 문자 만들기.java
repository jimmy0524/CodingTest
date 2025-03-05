class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String[] arr = s.split(" ", -1); //공백 기준으로 분리
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < arr.length; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < arr[i].length(); j++) {
                if (j % 2 == 0) {
                    temp.append(Character.toUpperCase(arr[i].charAt(j))); 
                } else {
                    temp.append(arr[i].charAt(j)); 
                }
            }
            sb.append(temp);
            
            if (i < arr.length - 1) {
                sb.append(" ");
            }
        }
    
        return sb.toString();
    }
}