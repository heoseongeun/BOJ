import java.io.*;
import java.util.*;

public class Main {
    static int n, k;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        int[] check = new int[100001];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0, end = 0, length = 0, answer = Integer.MIN_VALUE;
        while(end < n) {
            while(end < n && check[arr[end]] + 1 <= k) check[arr[end++]]++;
            length = Math.max(length, end - start);
            check[arr[start++]]--;
        }
        bw.write(length + "");
        bw.flush();
    }
}