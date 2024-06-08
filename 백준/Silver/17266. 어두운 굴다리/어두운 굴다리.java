import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int height = arr[0];
        for(int i = 1; i < m; i++) {
            if((arr[i] - arr[i - 1]) % 2 == 0) height = Math.max(height, (arr[i] - arr[i - 1]) / 2);
            else height = Math.max(height, (arr[i] - arr[i - 1]) / 2 + 1);
        }
        height = Math.max(height, n - arr[m - 1]);
        bw.write(height + "");
        bw.flush();
    }
}