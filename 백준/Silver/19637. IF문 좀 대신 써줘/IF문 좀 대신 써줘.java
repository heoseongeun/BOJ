import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] exp = new int[n];
        String[] str = new String[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            str[i] = st.nextToken();
            exp[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < m; i++) {
            int input = Integer.parseInt(br.readLine());
            int start = 0, end = n - 1;
            while(start <= end) {
                int mid = (start + end) / 2;
                if(exp[mid] < input) start = mid + 1;
                else end = mid - 1;
            }
            bw.write(str[start] + "\n");
        }
        bw.flush();
    }
}