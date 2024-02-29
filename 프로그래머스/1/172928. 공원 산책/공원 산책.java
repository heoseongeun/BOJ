class Solution {
    public int[] solution(String[] park, String[] routes) {
        int x = 0, y = 0;
        String s = "";
        for(int i = 0; i < park.length; i++) {
            s = park[i];
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                if(c == 'S') {
                    y = i;
                    x = j;
                    break;
                }
            }
        }
        for(int i = 0; i < routes.length; i++) {
            char c = routes[i].charAt(0);
            int n = routes[i].charAt(2) - '0';
            int nx = x, ny = y;
            System.out.println("index" + i);
            for(int j = 0; j < n; j++) {
                if(c == 'N') ny--;
                else if(c == 'S') ny++;
                else if(c == 'W') nx--;
                else if(c == 'E') nx++;
                if(nx < 0 || nx >= park[0].length()
                   || ny < 0 || ny >= park.length ||
                  park[ny].charAt(nx) == 'X') break; 
                if(j == n - 1) {
                    x = nx;
                    y = ny;
                }
            }
        }
        return new int[]{y, x};
    }
}