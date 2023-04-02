import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            switch (c) {
                case '+': case '-': case '*': case '/':
                    while(!stack.isEmpty() && priority(stack.peek()) >= priority(c)) {
                        bw.write(stack.pop());
                    }
                    stack.add(c);
                    break;
                case '(':
                    stack.add(c);
                    break;
                case ')':
                    while(!stack.isEmpty() && stack.peek() != '(') {
                        bw.write(stack.pop());
                    }
                    stack.pop();
                    break;
                default:
                    bw.write(c);
            }
        }
        while(!stack.isEmpty()) bw.write(stack.pop());
        bw.flush();
    }

    public static int priority(char o) {
        if(o == '(' || o == ')') return 0;
        else if(o == '+' || o == '-') return 1;
        else if(o == '*' || o == '/') return 2;
        return -1;
    }
}