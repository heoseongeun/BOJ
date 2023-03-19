import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int min = 10001;
        for(int i = M; i <= N; i++) {
            if(isPrime(i)) {
                sum += i;
                if(min > i) min = i;
            }
        }
        if(sum == 0) System.out.println(-1);
        else {
            System.out.println(sum);
            System.out.println(min);
        }
        br.close();
    }

    public static boolean isPrime(int n) {
        if(n == 2) return true;
        if(n % 2 == 0 || n < 2) return false;
        boolean check = true;
        for(int j = 3; j <= Math.sqrt(n); j += 2) {
            if(n % j == 0) {
                check = false;
                break;
            }
        }
        return check;
    }
}