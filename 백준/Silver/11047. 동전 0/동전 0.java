import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        for(int i = N - 1; i >= 0; i--) {
            if(K >= arr[i]) {
                cnt += (K / arr[i]);
                K %= arr[i];
            }
        }
        bw.write(cnt + "");
        br.close();
        bw.close();
    }
}