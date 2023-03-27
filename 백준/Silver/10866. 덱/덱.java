import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            switch (st.nextToken()) {
                case "push_back":
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case "push_front":
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case "front":
                    if(deque.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(deque.getFirst() + "\n");
                    break;
                case "back":
                    if(deque.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(deque.getLast() + "\n");
                    break;
                case "size":
                    bw.write(deque.size() + "\n");
                    break;
                case "empty":
                    if(deque.isEmpty()) bw.write(1 + "\n");
                    else bw.write(0 + "\n");
                    break;
                case "pop_back":
                    if(deque.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(deque.removeLast() + "\n");
                    break;
                case "pop_front":
                    if(deque.isEmpty()) bw.write(-1 + "\n");
                    else bw.write(deque.removeFirst() + "\n");
                    break;
            }
        }
        bw.flush();
        br.close();
    }
}