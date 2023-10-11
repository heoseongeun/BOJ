import java.io.*;
import java.util.*;

public class Main {
    static int f, s, g, u, d;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());
        u = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        arr = new int[f + 1];
        int result = bfs();
        if(result == -1) bw.write("use the stairs");
        else bw.write(result + "");
        br.close();
        bw.close();
    }

    static int bfs() {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        arr[s] = 1;
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(cur == g) return arr[cur] - 1;
            if(cur + u <= f) {
                if(arr[cur + u] == 0) {
                    arr[cur + u] = arr[cur] + 1;
                    q.add(cur + u);
                }
            }
            if(cur - d > 0) {
                if(arr[cur - d] == 0) {
                    arr[cur - d] = arr[cur] + 1;
                    q.add(cur - d);
                }
            }
        }
        return -1;
    }
}