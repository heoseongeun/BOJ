import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] ascending = new int[n];
        int[] descending = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            ascending[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && ascending[i] < ascending[j] + 1)
                    ascending[i] = ascending[j] + 1;
            }
        }
        for(int i = n - 1; i >= 0; i--) {
            descending[i] = 1;
            for(int j = n - 1; j > i; j--) {
                if(arr[i] > arr[j] && descending[i] < descending[j] + 1)
                    descending[i] = descending[j] + 1;
            }
        }
        int max = 0;
        for(int i = 0; i < n; i++)
            if(ascending[i] + descending[i] > max) max = ascending[i] + descending[i];
        bw.write(max - 1 + "");
        bw.flush();
        bw.close();
        br.close();
    }
}