import java.io.*;
import java.util.*;

public class Main {
    static int A, B, C;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int result = 0;
        if((A + B + C) % 3 == 0) {
            Queue<int[]> q = new LinkedList<>();
            boolean[][] visited = new boolean[1501][1501];
            q.add(new int[]{A, B, C});
            visited[A][B] = true;
            while(!q.isEmpty()) {
                int[] tmp = q.poll();
                int a = tmp[0];
                int b = tmp[1];
                int c = tmp[2];
                if(a == b && b == c) {
                    result = 1;
                    break;
                }
                if(a != b) {
                    int na = a > b ? a - b : a + a;
                    int nb = a > b ? b + b : b - a;
                    if(!visited[na][nb]) {
                        q.add(new int[]{na, nb, c});
                        visited[na][nb] = true;
                    }
                }
                if(b != c) {
                    int nb = b > c ? b - c : b + b;
                    int nc = b > c ? c + c : c - b;
                    if(!visited[nb][nc]) {
                        q.add(new int[]{a, nb, nc});
                        visited[nb][nc] = true;
                    }
                }
                if(a != c) {
                    int na = a > c ? a - c : a + a;
                    int nc = a > c ? c + c : c - a;
                    if(!visited[na][nc]) {
                        q.add(new int[]{na, b, nc});
                        visited[na][nc] = true;
                    }
                }
            }
        }
        bw.write(result + "");
        br.close();
        bw.close();
    }
}