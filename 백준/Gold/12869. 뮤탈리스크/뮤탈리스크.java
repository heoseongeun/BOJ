import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] scv = new int[3];
        for(int i = 0; i < N; i++) scv[i] = Integer.parseInt(st.nextToken());

        bw.write(bfs(scv) + "");
        br.close();
        bw.close();
    }

    static int bfs(int[] scv) {
        boolean [][][] visited = new boolean[61][61][61];
        int[][] deal = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 3, 9}, {1, 9, 3}};
        int[][][] dp = new int[61][61][61];
        Queue<SCV> q = new LinkedList<>();
        visited[0][0][0] = true;
        q.add(new SCV(0, 0, 0, 0));
        while(!q.isEmpty()) {
            SCV s = q.poll();
            for(int i = 0; i < 6; i++) {
                int n1 = s.s1 + deal[i][0];
                int n2 = s.s2 + deal[i][1];
                int n3 = s.s3 + deal[i][2];
                if(n1 > 60) n1 = 60;
                if(n2 > 60) n2 = 60;
                if(n3 > 60) n3 = 60;
                if(visited[n1][n2][n3]) continue;
                if(n1 >= scv[0] && n2 >= scv[1] && n3 >= scv[2]) return s.cnt + 1;
                visited[n1][n2][n3] = true;
                q.add(new SCV(n1, n2, n3, s.cnt + 1));
            }


        }
        return -1;
    }

    static class SCV {
        int s1;
        int s2;
        int s3;
        int cnt;

        public SCV(int s1, int s2, int s3, int cnt) {
            this.s1 = s1;
            this.s2 = s2;
            this.s3 = s3;
            this.cnt = cnt;
        }
    }
}