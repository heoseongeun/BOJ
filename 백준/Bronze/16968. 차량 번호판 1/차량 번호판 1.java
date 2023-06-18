import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine(); // c 문자, d 숫자
        char c = s.charAt(0);
        int result = (c == 'c') ? 26 : 10 ;
        for(int i = 1; i < s.length(); i++) {
            char tmp = s.charAt(i);
            if(tmp == 'c') {
                if(c == tmp) result *= 25;
                else {
                    result *= 26;
                    c = tmp;
                }
            } else if(tmp == 'd') {
                if(c == tmp) result *= 9;
                else {
                    result *= 10;
                    c = tmp;
                }
            }
        }
        bw.write(result + "");
        bw.flush();
        bw.close();
        br.close();
    }
}