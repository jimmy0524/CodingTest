import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }
        for (String s : callings) {
            int index = map.get(s);
            map.put(s, index - 1);
            String player = players[index - 1];
            map.put(player, index);
            players[index - 1] = s;
            players[index] = player;
        }
        return players;
    }
}