import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean complete;
    static long[] answer;
    static boolean[] visited;
    static ArrayList<Long> num = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        answer = new long[N];
        visited = new boolean[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) num.add(Long.parseLong(st.nextToken()));
        Collections.sort(num);
        for(int i = 0; i < N; i++) {
            if(complete) break;
            calc(0, i);
        }
        for(long i: answer) bw.write(i + " ");
        br.close();
        bw.close();
    }

    static void calc(int cnt, int idx) {
        if(answer[N - 1] != 0) {
            complete = true;
            return;
        }
        if(!visited[idx]) {
            visited[idx] = true;
            answer[cnt] = num.get(idx);
            if(num.get(idx) % 3 == 0) {
                for(int i = idx - 1; i >= 0; i--) {
                    if(num.get(idx) / 3 == num.get(i)) {
                        calc(cnt + 1, i);
                        break;
                    }
                }
            }
            long tmp = num.get(idx) * 2;
            for(int i = idx + 1; i < N; i++) {
                if(tmp == num.get(i)) {
                    calc(cnt + 1, i);
                    break;
                }
            }
        }
        visited[idx] = false;
    }
}