import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int max = 0;
        int[] arr = new int[N];
        for (int n = 0; n < N; n++) {
            int score = Integer.parseInt(st.nextToken());
            if(max < score) max = score;
            arr[n] = score;
        }
        double result = 0;
        for(int i = 0; i < N; i++) {
            result += (((double) arr[i] / max) * 100);
        }
        System.out.println(result / N);
        br.close();
    }
}