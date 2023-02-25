import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for (int n = 0; n < 26; n++)
            if (!str.contains(Character.toString(alphabet.charAt(n)))) System.out.print("-1 ");
            else {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == alphabet.charAt(n)) {
                        System.out.print(i + " ");
                        break;
                    }
                }
            }
        br.close();
    }
}