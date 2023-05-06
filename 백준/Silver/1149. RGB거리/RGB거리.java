import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp;
    static int[][] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int T = Integer.parseInt(br.readLine());
        dp = new int[T][3];
        arr = new int[T][3];
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
            if(i == 0) {
                for(int j = 0; j < 3; j++) dp[i][j] = arr[i][j];
            }
        }
        bw.write(Math.min(cost(T - 1, 0), Math.min(cost(T - 1, 1), cost(T - 1, 2))) + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static int cost(int n, int color) {
        if(dp[n][color] == 0) { // red: 0, green: 1, blue: 2
            switch (color) {
                case 0:
                    dp[n][0] = Math.min(cost(n - 1, 1), cost(n - 1, 2)) + arr[n][0];
                    break;
                case 1:
                    dp[n][1] = Math.min(cost(n - 1, 0), cost(n - 1, 2)) + arr[n][1];
                    break;
                case 2:
                    dp[n][2] = Math.min(cost(n - 1, 0), cost(n - 1, 1)) + arr[n][2];
                    break;
            }
        }
        return dp[n][color];
    }
}