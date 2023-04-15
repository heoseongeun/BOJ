import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long N = Integer.parseInt(st.nextToken());
        long M = Integer.parseInt(st.nextToken());
        long two = count(N, 2) - count(N - M, 2) - count(M, 2);
        long five = count(N, 5) - count(N - M, 5) - count(M, 5);
        bw.write(String.valueOf(Math.min(two, five)));
        bw.flush();
    }

    public static long count(long input, long target) {
        long cnt = 0;
        for(long i = target; i <= input; i *= target) {
            cnt += input / i;
        }
        return cnt;
    }
}