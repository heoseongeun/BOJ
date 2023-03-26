import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < N; i++) queue.add(i + 1);
        String result = "<";
        int num;
        while(!queue.isEmpty()) {
            for(int i = 0; i < K; i++) {
                if(i == K - 1) {
                    result += queue.poll() + ", ";
                    break;
                }
                num = queue.poll();
                queue.add(num);
            }
        }
        result = result.substring(0, result.length() - 2) + ">";
        System.out.println(result);
        br.close();
    }
}