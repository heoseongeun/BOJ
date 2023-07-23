import java.io.*;
import java.util.*;

public class Main {
    static int L, C;
    static char[] arr, result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new char[C];
        result = new char[L];
        for(int i = 0; i < C; i++) arr[i] = st.nextToken().charAt(0);
        Arrays.sort(arr);
        code(0, 0);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    public static void code(int start, int depth) {
        if(depth == L) {
            if(isValid()) {
                for(char i: result) sb.append(i);
                sb.append("\n");
            }
            return;
        }
        for(int i = start; i < C; i++) {
            result[depth] = arr[i];
            code(i + 1, depth + 1);
        }
    }

    public static boolean isValid() {
        int j = 0, m = 0;
        for(int i : result) {
            if(i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u') {
                m++;
            } else j++;
            if(m >= 1 && j >= 2) return true;
        }
        return false;
    }
}