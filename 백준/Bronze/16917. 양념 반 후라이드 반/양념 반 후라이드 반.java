import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken()); // 양념
        int b = Integer.parseInt(st.nextToken()); // 후라이드
        int c = Integer.parseInt(st.nextToken()); // 반반
        int x = Integer.parseInt(st.nextToken()); // 양념 개수
        int y = Integer.parseInt(st.nextToken()); // 후라이드 개수
        int cnt = 0;
        if((a + b) <= c * 2) {
            cnt += (a * x) + (b * y);
        } else {
            if(x > y) {
                cnt += y * (c * 2);
                cnt += Math.min((x - y) * a, (x - y) * (c * 2));
            } else {
                cnt += x * (c * 2);
                cnt += Math.min((y - x) * b, (y - x) * (c * 2));
            }
        }
        bw.write(cnt + "");
        br.close();
        bw.close();
    }
}