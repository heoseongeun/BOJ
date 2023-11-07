import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        List<List<Integer>> map = new ArrayList<>();
        for(int i = 0; i <= N; i++) map.add(new ArrayList<>());
        int[] time = new int[N + 1];
        int[] cnt = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            time[i] = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            for(int j = 0; j < t; j++) {
                int tmp = Integer.parseInt(st.nextToken());
                map.get(tmp).add(i);
                cnt[i]++;
            }
        }
        int[] res = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            res[i] = time[i];
            if(cnt[i] == 0) q.add(i);
        }
        while(!q.isEmpty()) {
            int cur = q.poll();
            for(int next: map.get(cur)) {
                cnt[next]--;
                res[next] = Math.max(res[next], res[cur] + time[next]);
                if(cnt[next] == 0) q.add(next);
            }
        }
        int answer = Integer.MIN_VALUE;
        for(int i: res) {
            if(answer < i) answer = i;
        }
        bw.write(answer + "");
        br.close();
        bw.close();
    }
}