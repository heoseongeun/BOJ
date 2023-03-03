import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[5];
        for(int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
        }
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                if(arr[j].length() <= i) continue;
                System.out.print(arr[j].charAt(i));
            }
        }
        br.close();
    }
}