import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int min = Integer.MAX_VALUE;
        int[] answer = new int[2];
        for(int i = 0; i < n; i++) {
            int start = i + 1;
            int end = n - 1;
            while (start <= end) {
                int mid = (start + end)/2;

                int sum = arr[i] + arr[mid];

                if (Math.abs(sum) < min) {
                    answer[0] = arr[i];
                    answer[1] = arr[mid];
                    min = Math.abs(sum);
                }

                if (sum < 0) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        bw.write(answer[0] + " " + answer[1]);
        bw.flush();
    }
}