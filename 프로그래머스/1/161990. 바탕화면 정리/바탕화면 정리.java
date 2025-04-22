class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int as = 0;
        int ae = 0;
        int bs = 0;
        int be = 0;
        here:
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[i].length(); j++) {
                if(wallpaper[i].charAt(j) == '#') {
                    as = i;
                    break here;
                }
            }
        }
        
        here:
        for (int j = 0; j < wallpaper[0].length(); j++) {
          for (int i = 0; i < wallpaper.length; i++) {
                if(wallpaper[i].charAt(j) == '#') {
                    ae = j;
                    break here;
                }
            }
        }
        
        here:
        for (int i = wallpaper.length - 1; i >= 0; i--) {
            for (int j = wallpaper[i].length() - 1; j >= 0; j--) {
                if(wallpaper[i].charAt(j) == '#') {
                    bs = i + 1;
                    break here;
                }
            }
        }
        
        here:
        for (int j = wallpaper[0].length() - 1; j >= 0; j--) {
            for (int i = wallpaper.length - 1; i >= 0; i--) {
                if(wallpaper[i].charAt(j) == '#') {
                    be = j + 1;
                    break here;
                }
            }
        }
        
        return new int[]{as, ae, bs, be};
    }
}