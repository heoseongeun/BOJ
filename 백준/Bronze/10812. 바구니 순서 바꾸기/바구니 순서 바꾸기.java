import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N + 1];
        for(int i = 1; i <= N; i++) arr[i] = i;
        for (int n = 0; n < M; n++) {
            StringTokenizer s = new StringTokenizer(br.readLine(), " ");
            int i = Integer.parseInt(s.nextToken());
            int j = Integer.parseInt(s.nextToken());
            int k = Integer.parseInt(s.nextToken());
            int[] temp = arr.clone();
            int idx = i;
            for(int m = k; m <= j; m++) arr[idx++] = temp[m];
            for(int m = i; m < k; m++) arr[idx++] = temp[m];
        }
        for(int i = 0; i < N; i++) {
            System.out.print(arr[i + 1] + " ");
        }
        br.close();
    }
}