import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());
        if(next()) {
            for(int i: arr) System.out.print(i + " ");
        } else System.out.println(-1);
        br.close();
    }

    public static boolean next() {
        int i = n - 1;
        while(i > 0 && arr[i - 1] >= arr[i]) --i;
        if(i == 0) return false;
        int j = n - 1;
        while(arr[i - 1] >= arr[j]) --j;
        swap(i - 1, j);
        int k = n - 1;
        while(i < k) swap(i++, k--);
        return true;
    }
    
    private static void swap(int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}