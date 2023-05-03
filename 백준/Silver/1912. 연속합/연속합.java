import java.io.*;
import java.util.*;

public class Main {
    static Integer[] dp;
    static int[] arr;
    static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[N];
        dp = new Integer[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        dp[0] = arr[0];
        max = arr[0];
        recur(N - 1);
        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int recur(int n) { // top-down
        if(dp[n] == null) {
            dp[n] = Math.max(recur(n - 1) + arr[n], arr[n]);
            max = Math.max(dp[n], max);
        }
        return dp[n];
    }
}