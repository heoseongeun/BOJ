import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] huddle = new int[101];
        int[] snake = new int[101];
        for(int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            huddle[start] = end;
        }
        // bfs
        int[] cnt = new int[101];
        boolean[] visited = new boolean[101];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()) {
            int num = q.poll();
            if(num == 100) {
                bw.write(cnt[num] + "");
                break;
            }
            for(int i = 1; i <= 6; i++) {
                int next = num + i;
                if(next > 100 || visited[next]) continue;
                visited[next] = true;
                if(huddle[next] != 0) {
                    if(!visited[huddle[next]]) {
                        q.add(huddle[next]);
                        visited[huddle[next]] = true;
                        cnt[huddle[next]] = cnt[num] + 1;
                    }
                } else {
                    q.add(next);
                    cnt[next] = cnt[num] + 1;
                }
            }
        }
        br.close();
        bw.close();
    }
}