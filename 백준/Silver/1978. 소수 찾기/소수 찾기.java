import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int result = 0;
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(n == 2) {
                result++;
                continue;
            }
            if(n % 2 == 0 || n < 2) continue;
            boolean check = true;
            for(int j = 3; j <= Math.sqrt(n); j += 2) {
                if(n % j == 0) {
                    check = false;
                    break;
                }
            }
            if(check) result++;
        }
        System.out.println(result);
        br.close();
    }
}