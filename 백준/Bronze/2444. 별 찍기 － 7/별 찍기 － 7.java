import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num = 1;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N - i - 1; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < num; j++) {
                System.out.print("*");
            }
            num += 2;
            System.out.println();
        }
        num -= 2;
        for(int i = 0; i < N - 1; i++) {
            num -= 2;
            for(int j = 0; j < i + 1; j++) {
                System.out.print(" ");
            }
            for(int j = 0; j < num; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        br.close();
    }
}