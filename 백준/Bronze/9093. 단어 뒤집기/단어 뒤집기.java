import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        for(int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            while(st.hasMoreTokens()) {
                String str = st.nextToken();
                for(int i = 0; i < str.length(); i++) stack.add(str.charAt(i));
                for(int i = 0; i < str.length(); i++) bw.write(stack.pop());
                bw.write(' ');
            }
            bw.write('\n');
            stack.clear();
        }
        br.close();
        bw.flush();
    }
}