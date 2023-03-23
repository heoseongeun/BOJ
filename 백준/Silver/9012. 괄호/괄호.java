import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Stack<Character> stack = new Stack<>();
        boolean check;
        for(int i = 0; i < T; i++) {
            check = true;
            String str = br.readLine();
            for(int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if(c == '(') stack.add(c);
                else if(c == ')') {
                    if(stack.isEmpty()){
                        check = false;
                        break;
                    }
                    stack.pop();
                }
            }
            if(check && stack.isEmpty()) System.out.println("YES");
            else System.out.println("NO");
            stack.clear();
        }
        br.close();
    }
}