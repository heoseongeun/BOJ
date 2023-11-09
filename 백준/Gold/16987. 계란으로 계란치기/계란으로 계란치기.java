import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int N, max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        bw.write(max + "");
        br.close();
        bw.close();
    }

    static void dfs(int idx, int cnt) {
        if(idx == N) {
            max = Math.max(max, cnt);
            return;
        }
        if(arr[idx][0] <= 0 || cnt == N - 1) {
            dfs(idx + 1, cnt);
            return;
        }
        int n = cnt;
        for(int i = 0; i < N; i++) {
            if(arr[i][0] <= 0 || i == idx) continue;
            arr[i][0] -= arr[idx][1];
            arr[idx][0] -= arr[i][1];
            if(arr[i][0] <= 0) cnt++;
            if(arr[idx][0] <= 0) cnt++;
            dfs(idx + 1, cnt);
            arr[i][0] += arr[idx][1];
            arr[idx][0] += arr[i][1];
            cnt = n;
        }
    }
}