import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String S = br.readLine();
        Stack<Character> stack = new Stack<>();
        boolean check = false;
        for(int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            if(c == '<') {
                while(!stack.isEmpty()) bw.write(stack.pop());
                check = true;
            } else if(c == '>') {
                check = false;
                bw.write(c);
                continue;
            }

            if(check) { // 괄호 안의 문자
                bw.write(c);
            } else { // 괄호 이외의 문자
                if(c == ' ') {
                    while(!stack.isEmpty()) bw.write(stack.pop());
                    bw.write(c);
                    continue;
                } else stack.add(c);
            }

            if(i == S.length() - 1) {
                while(!stack.isEmpty()) bw.write(stack.pop());
            }
        }
        bw.flush();
        br.close();
    }
}