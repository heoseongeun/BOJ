import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        String result = "";
        while(N > 0) {
            int tmp = N % B;
            if(tmp > 9) result = (char)(55 + tmp) + result;
            else result = tmp + result;
            N /= B;
        }
        bw.write(result);
        bw.flush();
        bw.close();
        br.close();
    }
}