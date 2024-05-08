import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        char c = st.nextToken().charAt(0);
        int num;
        if(c == 'Y') num = 1;
        else if(c == 'F') num = 2;
        else num = 3;
        Set<String> list = new HashSet<>();
        for(int i = 0; i < n; i++) {
            String name = br.readLine();
            list.add(name);
        }
        int cnt = list.size() / num;
        bw.write(cnt + "");
        br.close();
        bw.close();
    }
}