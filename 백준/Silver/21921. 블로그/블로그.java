import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int sum = 0;
        for(int i = 0; i < X; i++) {
            sum += arr[i];
        }
        int max = sum;
        int cnt = 1;
        for(int i = 0; i < N - X; i++) {
            sum += arr[i + X];
            sum -= arr[i];
            if(sum == max) cnt++;
            if(sum > max) {
                cnt = 1;
                max = sum;
            }
        }
        if(max == 0) bw.write("SAD");
        else bw.write(max + "\n" + cnt);
        bw.flush();
    }
}