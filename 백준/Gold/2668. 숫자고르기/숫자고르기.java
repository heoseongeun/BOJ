import java.io.*;
import java.util.*;

public class Main {
    static int n, num;
    static int[] arr;
    static boolean[] check;
    static List<Integer> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        check = new boolean[n + 1];
        result = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            check[i] = true;
            num = i;
            dfs(i);
            check[i] = false;
        }
        Collections.sort(result);
        bw.write(result.size() + "\n");
        for(int i: result) {
            bw.write(i + "\n");
        }
        bw.flush();
    }

    static void dfs(int i) {
        if(arr[i] == num) result.add(num);
        if(!check[arr[i]]) {
            check[arr[i]] = true;
            dfs(arr[i]);
            check[arr[i]] = false;
        }
    }
}