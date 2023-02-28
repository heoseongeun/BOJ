import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int index = 0;
        int result = 0;
        while(index < str.length() - 1) {
            result++;
            char c = str.charAt(index);
            if((c == 'c' || c == 's' || c == 'z') && str.charAt(index + 1) == '=') {
                index += 2;
            } else if((c == 'c' || c == 'd') && str.charAt(index + 1) == '-') {
                index += 2;
            } else if((c == 'l' || c == 'n') && str.charAt(index + 1) == 'j') {
                index += 2;
            } else if((index < str.length() - 2) && c == 'd' && str.charAt(index + 1) == 'z' && str.charAt(index + 2) == '=') {
                index += 3;
            } else index++;
        }
        if(index == str.length() - 1) result++;
        System.out.println(result);
        br.close();
    }
}