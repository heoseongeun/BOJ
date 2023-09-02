import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited = new boolean[2000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) recur(i, arr[i]);
        int answer = 0;
        for(int i = 1; i < visited.length; i++) {
            if(!visited[i]) {
                answer = i;
                break;
            }
        }
        bw.write(answer + "");
        br.close();
        bw.close();
    }

    static void recur(int idx, int num) {
        visited[num] = true;
        for(int i = idx + 1; i < N; i++) recur(i, num + arr[i]);
    }
}