import java.io.*;

public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = br.readLine();
        String t = br.readLine();
        dfs(s, t);
        bw.write(answer + "");
        bw.flush();
    }

    static void dfs(String s, String t) {
        if(s.length() == t.length()) {
            if(s.equals(t)) answer = 1;
        }
        if(t.endsWith("A")) dfs(s, t.substring(0, t.length() - 1));
        if(t.startsWith("B")) dfs(s, new StringBuilder(t.substring(1)).reverse().toString());
    }
}