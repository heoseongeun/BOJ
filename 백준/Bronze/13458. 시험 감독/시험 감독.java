import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, b, c;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        long answer = n;
        for(int i = 0; i < n; i++) {
            int num = arr[i];
            num -= b;
            if(num <= 0) continue;
            answer += num / c;
            if(num % c != 0) answer += 1;
        }
        System.out.println(answer);
        br.close();
    }
}