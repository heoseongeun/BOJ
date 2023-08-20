import java.io.*;
import java.util.*;

public class Main {
    static class emoticon {
        int clipboard = 0;
        int screen = 0;
        int second = 0;
        emoticon(int clipboard, int screen, int second) {
            this.clipboard = clipboard;
            this.screen = screen;
            this.second = second;
        }
    }

    // 행 : 화면 개수, 열 : 클립보드 개수
    static boolean[][] visited = new boolean[1001][1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        bfs(s);
        br.close();
    }

    static void bfs(int end) {
        Queue<emoticon> q = new LinkedList<>();
        q.add(new emoticon(0, 1, 0));
        visited[0][1] = true;
        while(!q.isEmpty()) {
            emoticon e = q.poll();
            if(e.screen == end) {
                System.out.println(e.second);
                return;
            }
            // 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장
            q.add(new emoticon(e.screen, e.screen, e.second + 1));
            visited[e.screen][e.screen] = true;
            // 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
            if(e.clipboard != 0 && e.screen + e.clipboard <= end &&
                !visited[e.clipboard][e.screen + e.clipboard]) {
                q.add(new emoticon(e.clipboard, e.screen + e.clipboard, e.second + 1));
                visited[e.clipboard][e.screen + e.clipboard] = true;
            }
            // 3. 화면에 있는 이모티콘 중 하나를 삭제
            if(1 <= e.screen && !visited[e.clipboard][e.screen - 1]) {
                q.add(new emoticon(e.clipboard, e.screen - 1, e.second + 1));
                visited[e.clipboard][e.screen - 1] = true;
            }
        }
    }
}