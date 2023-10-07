import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean[] prime = new boolean[10000];
        prime[0] = prime[1] = true;
        for(int i = 2; i < 10000; i++) {
            if(!prime[i]) {
                for(int j = i + i; j < 10000; j += i) prime[j] = true;
            }
        }
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int[] count = new int[10000];
            boolean[] visited = new boolean[10000];
            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            visited[start] = true;
            while(!q.isEmpty()) {
                int n = q.poll();
                for(int i = 0; i < 4; i++) {
                    for(int j = 0; j <= 9; j++) {
                        if(i == 0 && j == 0) continue;
                        int k = change(n, i, j);
                        if(!prime[k] && !visited[k]) {
                            q.add(k);
                            visited[k] = true;
                            count[k] = count[n] + 1;
                        }
                    }
                }
            }
            bw.write(count[end] + "\n");
        }
        br.close();
        bw.close();
    }

    static int change(int num, int i, int j) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        sb.setCharAt(i, (char) (j + '0'));
        return Integer.parseInt(sb.toString());
    }
}