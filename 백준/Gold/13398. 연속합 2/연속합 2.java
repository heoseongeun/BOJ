import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] ascending = new int[n];
        int[] descending = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        ascending[0] = arr[0];
        int max = ascending[0];
        for(int i = 1; i < n; i++) {
            ascending[i] = Math.max(ascending[i - 1] + arr[i], arr[i]);
            max = Math.max(ascending[i], max);
        }
        descending[n - 1] = arr[n - 1];
        for(int i = n - 2; i >= 0; i--)
            descending[i] = Math.max(descending[i + 1] + arr[i], arr[i]);
        for(int i = 1; i < n - 1; i++)
            max = Math.max(ascending[i - 1] + descending[i + 1], max);
        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }
}