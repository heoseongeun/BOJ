import java.util.*;

class Pos {
    int x, y, level;
    Pos(int x, int y, int level) {
        this.x = x;
        this.y = y;
        this.level = level;
    }
}

class Solution {
    int[] dx = {0, 0, 1, -1};
    int[] dy = {1, -1, 0, 0};
    char[][] map;
    boolean[][] visited;    
    int n, m;
    
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        Pos start = null, goal = null;
        boolean s = false, g = false;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                map[i][j] = board[i].charAt(j);
                if(map[i][j] == 'R') start = new Pos(i, j, 0);
                if(map[i][j] == 'G') goal = new Pos(i, j, 0);
            }
        }
        return bfs(start, goal);
    }
    
    int bfs(Pos start, Pos goal) {
        Queue<Pos> q = new LinkedList<>();
        visited[start.x][start.y] = true;
        q.add(start);
        while(!q.isEmpty()) {
            Pos now = q.poll();
            int x = now.x;
            int y = now.y;
            int level = now.level;
            if(x == goal.x && y == goal.y) return level;
            for(int i = 0; i < 4; i++) {
                Pos next = getPos(i, now);
                if(!visited[next.x][next.y]) {
                    visited[next.x][next.y] = true;
                    q.add(next);
                }
            }
        }
        return -1;
    }
    
    Pos getPos(int index, Pos now) {
        int x = now.x, y = now.y;
        int ix = dx[index];
        int iy = dy[index];
        while(x + ix >= 0 && x + ix < n && y + iy >= 0 && y + iy < m
             && map[x + ix][y + iy] != 'D') {
            x += ix;
            y += iy;
        }
        return new Pos(x, y, now.level + 1);
    }
}