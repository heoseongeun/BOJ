import java.io.*;
import java.util.*;

public class Main {
    static int[] result, arr;
    static int n, m;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        result = new int[m];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        dfs(0, 0);
        System.out.println(sb);
        br.close();
    }

    public static void dfs(int num, int depth) {
        if(depth == m) {
            for(int i: result) sb.append(i + " ");
            sb.append('\n');
            return;
        }
        int before = 0;
        for(int i = num; i < n; i++) {
            if(before != arr[i]) {
                result[depth] = arr[i];
                before = arr[i];
                dfs(i, depth + 1);
            }
        }
    }
}