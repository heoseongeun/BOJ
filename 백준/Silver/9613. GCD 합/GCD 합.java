import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int n = Integer.parseInt(st.nextToken());
            long answer = 0;
            int[] arr = new int[n];
            for(int j = 0; j < n; j++) arr[j] = Integer.parseInt(st.nextToken());
            for(int j = 0; j < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    answer += gcd(arr[j], arr[k]);
                }
            }
            bw.write(answer + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int gcd(int a, int b) {
        while(b > 0) {
            int tmp = b;
            b = a % b;
            a = tmp;
        }
        return a;
    }
}