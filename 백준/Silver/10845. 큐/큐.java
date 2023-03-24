import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        int num = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String str = st.nextToken();
            switch (str) {
                case "push":
                    num = Integer.parseInt(st.nextToken());
                    queue.offer(num);
                    break;
                case "pop":
                    if(queue.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(queue.poll() + "\n");
                    break;
                case "size":
                    bw.write(queue.size() + "\n");
                    break;
                case "empty":
                    if(queue.isEmpty()) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                    break;
                case "front":
                    if(queue.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(queue.peek() + "\n");
                    break;
                case "back":
                    if(queue.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(num + "\n");
                    break;
            }
        }
        bw.flush();
        br.close();
    }
}