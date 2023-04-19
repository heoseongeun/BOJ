import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String N = br.readLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N.length(); i++) {
            String s = Integer.toBinaryString(N.charAt(i) - '0');
            if(s.length() == 2 && i != 0) s = "0" + s;
            if(s.length() == 1 && i != 0) s = "00" + s;
            sb.append(s);
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}