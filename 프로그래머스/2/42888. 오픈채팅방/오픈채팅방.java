import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> map = new HashMap<>();
        for (String s : record) {
            String[] arr = s.split(" ");
            if (!arr[0].equals("Leave")) {
                map.put(arr[1], arr[2]);
            }
        }
        
        ArrayList<String> result = new ArrayList<>();
        for (String s : record) {
            StringBuilder sb = new StringBuilder();
            String[] arr = s.split(" ");
            if (!arr[0].equals("Change")) {
                sb.append(map.get(arr[1]) + "님이 ");
                switch (arr[0]) {
                    case "Enter" :
                        sb.append("들어왔습니다.");
                        break;
                    case "Leave" :
                        sb.append("나갔습니다.");
               }
            result.add(sb.toString());
            }
        }
        
        return result.toArray(new String[0]);
    }
}