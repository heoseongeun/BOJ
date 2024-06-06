import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> list = new HashSet<>();
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            list.add(s);
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), ",");
            while(st.hasMoreTokens()) {
                String keyword = st.nextToken();
                if(list.contains(keyword)) {
                    list.remove(keyword);
                    n--;
                }
            }
            if(i == m - 1) bw.write(n + "");
            else bw.write(n + "\n");
        }
        bw.flush();
    }
}