import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;
        boolean[] arr = new boolean[26];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            boolean check = true;
            arr[str.charAt(0) - 'a'] = true;
            for(int j = 1; j < str.length(); j++) {
                int index = str.charAt(j) - 'a';
                if(!arr[index]) arr[index] = true;
                else if((str.charAt(j - 1) != str.charAt(j)) && arr[index]) {
                    check = false;
                    break;
                }
            }
            Arrays.fill(arr, false);
            if(check) result++;
        }
        System.out.println(result);
        br.close();
    }
}