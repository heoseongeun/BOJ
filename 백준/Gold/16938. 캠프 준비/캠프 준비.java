import java.io.*;
import java.util.*;

public class Main {
    static int N, L, R, X, result = 0;
    static int[] level;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        level = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) level[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) dfs(i, level[i], level[i], level[i], 1);
        bw.write(result + "");
        br.close();
        bw.close();
    }

    static void dfs(int depth, int min, int max, int sum, int cnt) {
        if(sum >= L && sum <= R && cnt > 1 && min <= max - X) ++result;
        for(int i = depth + 1; i < N; i++)
            dfs(i, level[i] < min ? level[i] : min,
                    level[i] > max ? level[i] : max, sum + level[i], cnt + 1);
    }
}