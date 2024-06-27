import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[t];
        for(int i = 0; i < t; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Stack<int[]> stack = new Stack<>();
        for(int i = 0; i < t; i++) {
            while(!stack.isEmpty()) {
                if(stack.peek()[1] >= arr[i]) {
                    bw.write((stack.peek()[0] + 1) + " ");
                    break;
                }
                stack.pop();
            }
            if(stack.isEmpty()) bw.write("0 ");
            stack.push(new int[]{i, arr[i]});
        }
        bw.flush();
    }
}