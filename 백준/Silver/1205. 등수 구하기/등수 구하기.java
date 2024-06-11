import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int score = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        if(n != 0) {
            st = new StringTokenizer(br.readLine(), " ");
            int[] arr = new int[n];
            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            if(n >= p && arr[0] >= score) {
                bw.write("-1");
            } else {
                int result = 1;
                for(int i = n - 1; i >= 0; i--) {
                    if(arr[i] <= score) {
                        break;
                    }
                    result++;
                }
                bw.write(result + "");
            }
        } else bw.write("1");
        bw.flush();
    }
}