import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int[] result = new int[26];
        for(int i = 0; i < input.length(); i++) result[input.charAt(i) - 'a']++;
        for(int i: result) bw.write(i + " ");
        bw.flush();
    }
}