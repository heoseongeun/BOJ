import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        while(true) {
            if(N % 5 == 0) {
                result += N / 5;
                System.out.println(result);
                break;
            } else {
                N -= 3;
                result++;
            }
            if(N < 0) {
                System.out.println(-1);
                break;
            }
        }
        br.close();
    }
}