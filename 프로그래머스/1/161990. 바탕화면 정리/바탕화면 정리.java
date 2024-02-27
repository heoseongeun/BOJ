class Solution {
    public int[] solution(String[] wallpaper) {
        int n = wallpaper.length, m = wallpaper[0].length();
        int startX = m, startY = n, endX = 0, endY = 0;
        for(int i = 0; i < n; i++) {
            String s = wallpaper[i];
            for(int j = 0; j < m; j++) {
                char c = s.charAt(j);
                if(c == '#') {
                    if(startX > j) startX = j;
                    if(startY > i) startY = i;
                    if(endX < j) endX = j;
                    if(endY < i) endY = i;
                }
            }
        }
        return new int[]{startY, startX, endY + 1, endX + 1};
    }
}