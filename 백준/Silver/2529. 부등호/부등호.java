import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[] arr = new char[10];
    static boolean[] visited = new boolean[10];
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < n; i++) arr[i] = st.nextToken().charAt(0);
        go(0, "");
        Collections.sort(list);
        System.out.println(list.get(list.size() - 1));
        System.out.println(list.get(0));
        br.close();
    }
    
    static boolean check(char a, char b, char c) {
        if(c == '<') {
            if(a > b) return false;
        }
        if(c == '>') {
            if(a < b) return false;
        }
        return true;
    }

    static void go(int index, String num) {
        if(index == n + 1) {
            list.add(num);
            return;
        }
        for(int i = 0; i < 10; i++) {
            if(visited[i]) continue;
            if(index == 0 || check(num.charAt(index - 1), (char) (i + '0'), arr[index - 1])) {
                visited[i] = true;
                go(index + 1, num + Integer.toString(i));
                visited[i] = false;
            }
        }
    }
}