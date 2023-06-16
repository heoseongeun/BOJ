import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int year = x, cnt = x;
            for(int j = 0; j < n; j++) {
                int tmp;
                if(year % n == 0) tmp = n;
                else tmp = year % n;
                if(tmp == y) break;
                year += m;
                cnt += m;
            }
            if(cnt > lcm(m, n)) cnt = -1;
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
    
    public static int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    public static int gcd(int a, int b) {
        if(b == 0) return a;
        else return gcd(b, a % b);
    }
}