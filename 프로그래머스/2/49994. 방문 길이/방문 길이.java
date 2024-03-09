import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[][] arr = new int[11][11];
        boolean[][][][] check = new boolean[11][11][11][11];
        HashMap<Character, int[]> map = new HashMap<>();
        map.put('U', new int[]{0, 1});
        map.put('D', new int[]{0, -1});
        map.put('R', new int[]{1, 0});
        map.put('L', new int[]{-1, 0});
        int[] pos = new int[]{5, 5}; // 현재 위치
        for(int i = 0; i < dirs.length(); i++) {
            char c = dirs.charAt(i);
            int[] tmp = map.get(c);
            int x = pos[0], y = pos[1];
            int nx = x + tmp[0];
            int ny = y + tmp[1];
            if(nx >= 0 && nx < 11 && ny >= 0 && ny < 11) {
                pos[0] = nx;
                pos[1] = ny;
                // 왔던 길이면 continue
                if(check[nx][ny][x][y] || check[x][y][nx][ny]) continue;
                check[nx][ny][x][y] = true;
                check[x][y][nx][ny] = true;
                answer++;
            }
        }
        return answer;
    }
}