import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<Integer>();

        int N = Integer.parseInt(br.readLine());
        int[] count = new int[1000001];
        int[] index = new int[N];
        int[] seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            index[i] = Integer.parseInt(st.nextToken());
            count[index[i]]++;
        }

        for(int i = 0; i < N; i++) {
            while(!stack.isEmpty() && count[index[i]] > count[index[stack.peek()]]) {
                seq[stack.pop()] = index[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) seq[stack.pop()] = -1;

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) sb.append(seq[i]).append(' ');

        System.out.println(sb);
    }
}
