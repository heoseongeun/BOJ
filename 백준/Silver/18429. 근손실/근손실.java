import java.io.*;
import java.util.*;

public class Main {
    static int n, k, cnt = 0;
    static int[] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visited = new boolean[n];
        back(500, 0);
        bw.write(cnt + "");
        br.close();
        bw.close();
    }
    // 순서 정하기
    public static void back(int sum, int idx) {
        if(idx == n) {
            cnt++;
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i] && (sum + arr[i] - k) >= 500) {
                visited[i] = true;
                back(sum + arr[i] - k, idx + 1);
                visited[i] = false;
            }
        }
    }
}