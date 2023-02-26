import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            for(int j = 0; j < N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int avg = Arrays.stream(arr).sum() / N;
            int cnt = 0;
            for(int j = 0; j < N; j++) {
                if(arr[j] > avg) cnt++;
            }
            System.out.println(String.format("%.3f", (double) cnt / N * 100) + "%");
        }
        br.close();
    }
}