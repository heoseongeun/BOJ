import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] dist = new int[n - 1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n - 1; i++) {
            dist[i] = Integer.parseInt(st.nextToken());
        }
        int[] price = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        if(n == 2) bw.write(dist[0] * price[0] + "");
        else if (n == 3) {
            if(price[0] * (dist[0] + dist[1]) > price[0] * dist[0] + price[1] * dist[1])
                bw.write((price[0] * dist[0] + price[1] * dist[1]) + "");
            else bw.write((price[0] * (dist[0] + dist[1])) + "");
        } else {
            int[] dp = new int[n + 1];
            dp[1] = dist[0] * price[0];
            for(int i = 2; i < n; i++) {
                dp[i] = Math.min(dp[i - 1] + (price[i - 1] * dist[i - 1]),
                Math.min(dp[i - 2] + (price[i - 2] * (dist[i - 1] + dist[i - 2])),
                dp[i - 2] + ((price[i - 2] * dist[i - 2]) + (price[i - 1] * dist[i - 1]))));
            }
            bw.write(dp[n - 1] + "");
        }
        bw.flush();
    }
}