import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input;
        char[] password;
        boolean flag;
        char prev;
        int cnt;
        while(!(input = br.readLine()).equals("end")) {
            cnt = 0;
            password = input.toCharArray();
            prev = '.';
            flag = false; // 모음 하나 이상 포함 여부
            for(char c: password) {
                if(check(c)) flag = true;
                if(check(c) != check(prev)) cnt = 1;
                else cnt++; // 같은 글자일 경우
                if(cnt > 2 || (prev == c && (c != 'e' && c != 'o'))) {
                    flag = false;
                    break;
                }
                prev = c;
            }
            if(flag) bw.write("<" + input + "> is acceptable.\n");
            else bw.write("<" + input + "> is not acceptable.\n");
        }
        br.close();
        bw.close();
    }
    
    public static boolean check(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}