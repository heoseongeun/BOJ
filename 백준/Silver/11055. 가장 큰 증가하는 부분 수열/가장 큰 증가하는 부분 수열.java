import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        dp[0] = arr[0];
        for(int i = 1; i < n; i++) {
            dp[i] = arr[i];
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j])
                    dp[i] = Math.max(dp[j] + arr[i], dp[i]);
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            if(dp[i] > max) max = dp[i];
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}