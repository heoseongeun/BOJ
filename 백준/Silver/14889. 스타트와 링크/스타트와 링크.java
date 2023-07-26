import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        combi(0, 0);
        System.out.println(min);
        bw.close();
        br.close();
    }

    public static void combi(int start, int depth) {
        if(depth == n / 2) {
            diff();
            return;
        }
        for(int i = start; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                combi(i + 1, depth + 1);
                visited[i] = false;
            }
        }
    }

    public static void diff() {
        int start = 0, link = 0;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                if(visited[i] && visited[j]) {
                    start += arr[i][j];
                    start += arr[j][i];
                }
                else if(!visited[i] && !visited[j]) {
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }
        int result = Math.abs(start - link);
        if(result == 0) {
            System.out.println(result);
            System.exit(0);
        }
        min = Math.min(result, min);
    }
}