import java.io.*;

public class Main {
    static int n;
    static int[] arr, result;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        result = new int[n];
        visited = new boolean[n];
        for(int i = 0; i < n; i++) arr[i] = i + 1;
        perm(0);
        System.out.println(sb);
        br.close();
    }

    public static void perm(int depth) {
        if(n == depth) {
            for(int i : result) sb.append(i + " ");
            sb.append("\n");
            return;
        }
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                result[depth] = arr[i];
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }
}