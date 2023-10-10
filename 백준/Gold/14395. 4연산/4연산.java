import java.io.*;
import java.util.*;

public class Main {
    static long s, t;
    static Set<Long> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        s = Long.parseLong(st.nextToken());
        t = Long.parseLong(st.nextToken());
        if(s == t) bw.write("0");
        else bw.write(bfs());
        br.close();
        bw.close();
    }

    static String bfs() {
        Queue<Num> q = new LinkedList<>();
        q.add(new Num(s, ""));
        set.add(s);
        while(!q.isEmpty()) {
            Num n = q.poll();
            if(n.num == t) return n.operator;
            for(int i = 0; i < 4; i++) {
                long num = 0;
                String s = "";
                switch (i) {
                    case 0:
                        num = n.num * n.num;
                        s += "*";
                        break;
                    case 1:
                        num = n.num + n.num;
                        s += "+";
                        break;
                    case 2:
                        num = n.num - n.num;
                        s += "-";
                        break;
                    case 3:
                        if(n.num != 0) num = n.num / n.num;
                        s += "/";
                        break;
                }
                if(!set.contains(num)) {
                    set.add(num);
                    q.add(new Num(num, n.operator + s));
                }
            }
        }
        return "-1";
    }

    static class Num {
        long num;
        String operator;

        Num(long num, String operator) {
            this.num = num;
            this.operator = operator;
        }
    }
}