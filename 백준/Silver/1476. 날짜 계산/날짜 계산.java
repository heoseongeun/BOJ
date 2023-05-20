import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int e = 1, s = 1, m = 1, year = 1;
        while (true) {
            if(e == E && s == S && m == M) break;
            e++; s++; m++; year++;
            if(e > 15) e = 1;
            if(s > 28) s = 1;
            if(m > 19) m = 1;
        }
        bw.write(year + "");
        bw.flush();
        bw.close();
        br.close();
    }
}