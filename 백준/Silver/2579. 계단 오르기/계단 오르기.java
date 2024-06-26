import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        int[] step = new int[t + 1];
        int[] dp = new int[t + 1];
        for(int i = 1; i <= t; i++) {
            step[i] = Integer.parseInt(br.readLine());
        }
        dp[1] = step[1];
        if(t >= 2) dp[2] = step[1] + step[2];
        for(int i = 3; i <= t; i++) {
            dp[i] = Math.max(dp[i - 2], dp[i - 3] + step[i - 1]) + step[i];
        }
        bw.write(dp[t] + "");
        bw.flush();
    }
}