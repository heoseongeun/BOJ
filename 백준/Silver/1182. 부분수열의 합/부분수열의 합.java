import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n, s, answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        dfs(0, 0);
        if(s == 0) bw.write(answer - 1 + "");
        else bw.write(answer + "");
        bw.close();
        br.close();
    }

    static void dfs(int depth, int sum) {
        if(depth == n) {
            if(sum == s) answer++;
            return;
        }
        dfs(depth + 1, sum + arr[depth]);
        dfs(depth + 1, sum);
    }
}