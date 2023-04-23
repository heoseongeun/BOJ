import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        int tmp = 0;
        for(int i = m - 1; i >= 0; i--) {
            tmp += Math.pow(A, i) * Integer.parseInt(st.nextToken());
        }
        Stack<Integer> stack = new Stack<>();
        while(tmp > 0) {
            stack.push(tmp % B);
            tmp /= B;
        }
        int size = stack.size();
        for(int i = 0; i < size; i++) {
            if(i == size - 1) bw.write(String.valueOf(stack.pop()));
            else bw.write(stack.pop() + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}