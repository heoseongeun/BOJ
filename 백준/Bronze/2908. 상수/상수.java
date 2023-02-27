import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String str1 = st.nextToken();
        String str2 = st.nextToken();
        int num1 = 0, num2 = 0, num = 1;
        for(int i = 0; i < 3; i++) {
            num1 += (str1.charAt(i) - '0') * num;
            num2 += (str2.charAt(i) - '0') * num;
            num *= 10;
        }
        if(num1 > num2) System.out.println(num1);
        else System.out.println(num2);
        br.close();
    }
}