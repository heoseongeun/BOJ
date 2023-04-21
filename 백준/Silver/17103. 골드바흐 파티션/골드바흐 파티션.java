import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 에라토스테네의 체
        boolean[] num = new boolean[1000001];
        num[0] = num[1] = true; // 소수 : false
        for(int i = 2; i * i <= 1000000; i++) {
            if(!num[i]) { // 소수이면, 그 배수는 소수 아님
                for(int j = i + i; j <= 1000000; j += i) num[j] = true;
            }
        }

        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for(int j = 2; j <= n / 2; j++) {
                if(!num[j] && !num[n - j]) cnt++;
            }
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}