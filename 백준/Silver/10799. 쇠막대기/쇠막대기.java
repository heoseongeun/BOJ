import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int result = 0;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c == '(') stack.add(c);
            else {
                stack.pop();
                if(input.charAt(i - 1) == '(') result += stack.size();
                else result++;
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
        br.close();
    }
}