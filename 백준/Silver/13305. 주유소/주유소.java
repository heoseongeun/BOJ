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
        long sum = 0;
        long min = price[0];
        for(int i = 0; i < n - 1; i++) {
            if(price[i] < min) min = price[i];
            sum += (min * dist[i]);
        }
        bw.write(sum + "");
        bw.flush();
    }
}