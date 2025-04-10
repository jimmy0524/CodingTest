import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, List<Song>> songs = new HashMap<>();
        HashMap<String, Integer> genreCount = new HashMap<>();
        
        for (int i = 0; i < genres.length; i++) {
            songs.putIfAbsent(genres[i], new ArrayList<>());
            songs.get(genres[i]).add(new Song(i, plays[i]));
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
        }
        ArrayList<String> genresList = new ArrayList<>(genreCount.keySet());
        genresList.sort((a,b) -> {return genreCount.get(b) -  genreCount.get(a);});
        ArrayList<Integer> result = new ArrayList<>();
        for (String s : genresList) {
            List<Song> songList = songs.get(s);
            songList.sort((a, b) -> {return b.count - a.count;});
            result.add(songList.get(0).index);
            if (songList.size() > 1) {
                result.add(songList.get(1).index);
            }
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    public class Song {
    int index;
    int count;
    
    Song(int i, int c) {
        index = i;
        count = c;
    }
}
}