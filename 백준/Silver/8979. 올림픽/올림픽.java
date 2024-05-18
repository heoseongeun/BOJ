import java.io.*;
import java.util.*;

class Node implements Comparable<Node> {
    int num, g, s, b, rank;
    Node(int num, int g, int s, int b, int rank) {
        this.num = num;
        this.g = g;
        this.s = s;
        this.b = b;
        this.rank = rank;
    }

    @Override
    public int compareTo(Node n) {
        if(this.g == n.g) {
            if(this.s == n.s)
                return n.b - this.b;
            else return n.s - this.s;
        } else return n.g - this.g;
    }
}

public class Main {
    static int n, k;
    static ArrayList<Node> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            list.add(new Node(num, gold, silver, bronze, 0));
        }
        Collections.sort(list);
        list.get(0).rank = 1;
        int point = 0;
        for(int i = 1; i < list.size(); i++) {
            Node now = list.get(i);
            int g = list.get(i - 1).g;
            int s = list.get(i - 1).s;
            int b = list.get(i - 1).b;
            if(list.get(i).num == k) point = i;
            if(now.g == g && now.s == s && now.b == b)
                list.get(i).rank = list.get(i - 1).rank;
            else list.get(i).rank = i + 1;
        }
        bw.write(list.get(point).rank + "");
        br.close();
        bw.close();
    }
}