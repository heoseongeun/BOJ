import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        int[] dp = new int[N];
        int max = -1;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
            max = Math.max(dp[i], max);
        }
        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
        br.close();
    }
}