import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int result = 0;
        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                for(int k = j + 1; k < N; k++) {
                    int sum = arr[i] + arr[j] + arr[k];
                    if(sum > M) continue;
                    else if(result < sum && sum <= M) result = sum;
                }
            }
        }
        System.out.println(result);
        br.close();
    }
}