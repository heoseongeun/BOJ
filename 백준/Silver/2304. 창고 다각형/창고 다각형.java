import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int[] arr = new int[1001];
        int N = Integer.parseInt(br.readLine());
        int start = Integer.MAX_VALUE, end = Integer.MIN_VALUE, max = Integer.MIN_VALUE, index = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int pos = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            arr[pos] = h;
            if(pos < start) start = pos;
            if(pos > end) end = pos;
            if(h > max) {
                max = h;
                index = pos;
            }
        }
        int height = arr[start], sum = 0, idx = start;
        for(int i = start; i <= index; i++) {
            if(height <= arr[i]) {
                sum += (i - idx) * height;
                height = arr[i];
                idx = i;
            }
        }
        height = arr[end];
        idx = end;
        for(int i = end; i >= index; i--) {
            if(height <= arr[i]) {
                sum += (idx - i) * height;
                height = arr[i];
                idx = i;
            }
        }
        sum += arr[index];
        bw.write(sum + "");
        bw.flush();
    }
}
