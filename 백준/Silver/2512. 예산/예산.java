import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        arr = new int[n];
        int sum = 0, max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            if(max < arr[i]) max = arr[i];
        }
        int m = Integer.parseInt(br.readLine());
        if(sum <= m) {
            bw.write(max + "");
        } else {
            int budget = m / n;
            // m을 넘기 전까지 계산
            while(true) {
                if(calc(budget) > m) break;
                budget++;
            }
            bw.write("" + (budget - 1));
        }
        bw.flush();
    }

    public static int calc(int num) {
        int sum = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] > num) sum += num;
            else sum += arr[i];
        }
        return sum;
    }
}