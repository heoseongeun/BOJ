import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] visited = new int[100001];
    static int[] before = new int[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        if(N == K) bw.write(0 + "\n" + N);
        else {
            bw.write(bfs(N) + "\n");
            Stack<Integer> stack = new Stack<>();
            StringBuilder sb = new StringBuilder();
            int after = K;
            while(after != N) {
                stack.push(after);
                after = before[after];
            }
            stack.push(N);
            while(!stack.isEmpty()) sb.append(stack.pop()).append(" ");
            bw.write(sb.toString() + " ");
        }
        bw.close();
        br.close();
    }

    static int bfs(int num) {
        Queue<Integer> q = new LinkedList<>();
        q.add(num);
        visited[num] = 1;
        while(!q.isEmpty()) {
            int n = q.poll();
            if(n == K) return visited[n] - 1;
            if(n - 1 >= 0 && visited[n - 1] == 0) {
                before[n - 1] = n;
                visited[n - 1] = visited[n] + 1;
                q.add(n - 1);
            }
            if(n + 1 <= 100000 && visited[n + 1] == 0) {
                before[n + 1] = n;
                visited[n + 1] = visited[n] + 1;
                q.add(n + 1);
            }
            if(2 * n <= 100000 && visited[2 * n] == 0) {
                before[2 * n] = n;
                visited[2 * n] = visited[n] + 1;
                q.add(2 * n);
            }
        }
        return -1;
    }
}