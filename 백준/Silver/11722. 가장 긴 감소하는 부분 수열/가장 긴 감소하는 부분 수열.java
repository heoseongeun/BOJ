import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            dp[i] = 1;
            for(int j = 1; j < i; j++) {
                if(arr[i] < arr[j])
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
            }
        }
        bw.write(Arrays.stream(dp).max().getAsInt() + "");
        bw.flush();
        bw.close();
        br.close();
    }
}