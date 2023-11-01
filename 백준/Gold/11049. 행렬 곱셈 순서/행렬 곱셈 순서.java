import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N][N];
        int[][] process = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            process[i][0] = Integer.parseInt(st.nextToken());
            process[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int k = 1; k < N; k++) {
            for(int i = 0; i + k <N; i++) {
                dp[i][i + k] = Integer.MAX_VALUE;
                for(int j = i; j < i + k; j++)
                    dp[i][i + k] = Math.min(dp[i][i + k], 
                            dp[i][j] + dp[j + 1][i + k] + process[i][0] * process[j][1] * process[i + k][1]);
            }
        }
        bw.write(dp[0][N - 1] + "");
        br.close();
        bw.close();
    }
}