import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        double[] arr = new double[N];
        for(int i = 0; i < N; i++) arr[i] = Double.parseDouble(br.readLine());

        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c < 'A') {
                double second = stack.pop();
                double first = stack.pop();
                switch (c) {
                    case '+':
                        stack.push(first + second);
                        break;
                    case '-':
                        stack.push(first - second);
                        break;
                    case '*':
                        stack.push(first * second);
                        break;
                    case '/':
                        stack.push(first / second);
                        break;
                }
            } else stack.push(arr[c - 'A']);
        }
        System.out.printf("%.2f", stack.pop());
    }
}
