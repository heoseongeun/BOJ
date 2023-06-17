import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int tmp = 10, result = 0, num = 1;
        for(int i = 1; i <= n; i++) {
            if(i % tmp == 0) {
                tmp *= 10;
                num++;
            }
            result += num;
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}