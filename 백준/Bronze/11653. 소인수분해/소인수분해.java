import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        while(N != 1) {
            int n = 2;
            while(N % n != 0) n++;
            bw.write(n + "\n");
            N /= n;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}