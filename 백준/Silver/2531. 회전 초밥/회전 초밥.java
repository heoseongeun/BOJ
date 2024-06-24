import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int max = 0;
        int start, end;
        for(int i = 0; i < n; i++) {
            Set<Integer> set = new HashSet<>();
            start = i;
            end = (start + k - 1) % n;
            if(start > end) {
                for(int j = start; j < n; j++) set.add(arr[j]);
                for(int j = 0; j <= end; j++) set.add(arr[j]);
            } else {
                for(int j = start; j <= end; j++) set.add(arr[j]);
            }
            set.add(c);
            if(set.size() > max) max = set.size();
        }
        bw.write("" + max);
        bw.flush();
    }
}