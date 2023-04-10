import java.io.*;
import java.util.*;

public class Main {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        prime = new boolean[N + 1];
        isPrime();
        for(int i = M; i <= N; i++) {
            if(!prime[i]) bw.write(i + "\n");
        }
        bw.flush();
    }

    public static void isPrime() {
        prime[0] = prime[1] = true; // true = 소수, false = 소수아님
        for(int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i]) continue;
            for(int j = i * i; j < prime.length; j += i) prime[j] = true;
        }
    }
}