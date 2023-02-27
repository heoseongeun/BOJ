import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        str = str.toUpperCase();
        int[] arr = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            arr[c - 'A']++;
        }
        char result = '0';
        int max = 0;
        for(int i = 0; i < 26; i++) {
            if(max == arr[i]) {
                result = '?';
            } else if(max < arr[i]) {
                max = arr[i];
                result = (char)(i + 'A');
            }
        }
        System.out.println(result);
        br.close();
    }
}