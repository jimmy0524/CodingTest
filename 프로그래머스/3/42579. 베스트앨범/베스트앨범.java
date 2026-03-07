import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreCount = new HashMap<>();
        HashMap<String, List<Song>> genreSongs = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            genreCount.put(genres[i], genreCount.getOrDefault(genres[i], 0) + plays[i]);
            genreSongs.putIfAbsent(genres[i], new ArrayList<>());
            genreSongs.get(genres[i]).add(new Song(i, plays[i])); 
        }
        
        ArrayList<String> genreList = new ArrayList<>(genreCount.keySet());
        //재생수로 정렬된 장르 리스트
        genreList.sort((a, b) -> genreCount.get(b) - genreCount.get(a));
        
        ArrayList<Integer> answer = new ArrayList<>();
        
        for (String genre : genreList) {
            ArrayList<Song> songs = new ArrayList<>(genreSongs.get(genre));
            songs.sort((a, b) -> b.count - a.count);
            int count = 0;
            for (Song song : songs) {
                if (count == 2) break;
                answer.add(song.index);
                count++;
            }
        }
        
        int[] answerArray = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerArray[i] = answer.get(i);
        }
        
        return answerArray;
    }
    
    private class Song {
        int index, count;
        
        public Song (int index, int count) {
            this.index = index;
            this.count = count;
        }
    }
}