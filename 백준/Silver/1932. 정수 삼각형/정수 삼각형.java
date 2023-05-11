import java.io.*;
import java.util.*;

public class Main {
    static Integer dp[][];
    static int arr[][];
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        dp = new Integer[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < i + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(i == n - 1) dp[i][j] = arr[i][j];
            }
        }
        bw.write(find(0, 0) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int find(int depth, int idx) {
        if(depth == n - 1) return dp[depth][idx];
        if(dp[depth][idx] == null)
            dp[depth][idx] = Math.max(find(depth + 1, idx), find(depth + 1, idx + 1))
                    + arr[depth][idx];
        return dp[depth][idx];
    }
}