import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int result = 0;
        for (int n = 0; n < N; n++) {
            result += str.charAt(n) - '0';
        }
        System.out.println(result);
        br.close();
    }
}