import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();
        int length = N.length();
        if(length % 3 == 2) N = "0" + N;
        if(length % 3 == 1) N = "00" + N;
        int n2 = 0, n3 = 0;
        for(int i = 0; i < N.length(); i++) {
            int num = N.charAt(i) - '0';
            if(i % 3 == 2) bw.write(String.valueOf(num + n2 + n3));
            else if(i % 3 == 1) n2 = num * 2;
            else n3 = num * 4;
        }
        bw.flush();
        bw.close();
        br.close();
    }
}