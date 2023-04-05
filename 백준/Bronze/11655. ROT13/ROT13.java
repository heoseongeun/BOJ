import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if(c >= 'A' && c <= 'Z' - 13) c = (char)(c + 13);
            else if(c >= 'Z' - 13 && c <= 'Z') c = (char)(c - 13);
            else if(c >= 'a' && c <= 'z' - 13) c = (char)(c + 13);
            else if(c >= 'z' - 13 && c <= 'z') c = (char)(c - 13);
            bw.write(c);
        }
        bw.flush();
    }
}