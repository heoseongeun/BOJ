import java.io.*;

public class Main { 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        if(N == 0) bw.write(String.valueOf(N));
        else {
            String result = "";
            while(N != 0) {
                result = Math.abs(N % -2) + result;
                N = (int) Math.ceil((double) N / -2);
            }
            bw.write(result);
        }
        bw.flush();
        bw.close();
        br.close();
    }
}