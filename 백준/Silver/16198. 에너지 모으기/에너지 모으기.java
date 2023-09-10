import java.io.*;
import java.util.*;

public class Main {
    static int N, max = Integer.MIN_VALUE;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) list.add(Integer.parseInt(st.nextToken()));
        charge(0);
        bw.write(max + "");
        br.close();
        bw.close();
    }

    static void charge(int sum) {
        if(list.size() == 2) {
            max = Math.max(max, sum);
            return;
        }
        for(int i = 1; i < list.size() - 1; i++) {
            int tmp = list.get(i);
            int num = list.get(i - 1) * list.get(i + 1);
            list.remove(i);
            charge(sum + num);
            list.add(i, tmp);
        }
    }
}