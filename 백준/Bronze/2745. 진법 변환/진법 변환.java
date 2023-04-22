import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String N = st.nextToken();
        int B = Integer.parseInt(st.nextToken());
        int result = 0;
        for(int i = N.length() - 1; i >= 0; i--) {
            char c = N.charAt(i);
            int n;
            if(c > 64) n = c - 'A' + 10;
            else n = c - '0';
            result += n * Math.pow(B, N.length() - 1 - i);
        }
        bw.write(String.valueOf(result));
        bw.flush();
        bw.close();
        br.close();
    }
}