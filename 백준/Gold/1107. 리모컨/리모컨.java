import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer> arr;
    static int min = Integer.MAX_VALUE;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        arr = new ArrayList<>();
        if(m > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < m; i++) arr.add(Integer.parseInt(st.nextToken()));
        }
        if(n == 100) bw.write(0 + "");
        else {
            min = Math.abs(n - 100);
            dfs(0, "");
            bw.write(min + "");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int idx, String s) {
        for(int i = 0; i < 10; i++) {
            if(!arr.contains(i)) {
                String str = s + i;
                int cnt = Math.abs(n - Integer.parseInt(str)) + str.length();
                min = Math.min(min, cnt);
                if(idx < 6) dfs(idx + 1, str);
            }
        }
    }
}