import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while((input = br.readLine()) != null) {
            int[] count = new int[4];
            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(c == ' ') count[3]++;
                else if(c >= 'a' && c <= 'z') count[0]++;
                else if(c >= 'A' && c <= 'Z') count[1]++;
                else count[2]++;
            }
            for(int i :count) System.out.print(i + " ");
            System.out.println();
        }
    }
}