import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();
        int result = 0;
        for(int i = 0; i < n - 1; i++) {
            int cnt = 0;
            int[] arr = new int[26];
            for(int j = 0; j < s.length(); j++) {
                arr[s.charAt(j) - 'A']++;
            }
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++) {
                if(arr[input.charAt(j) - 'A'] > 0) {
                    arr[input.charAt(j) - 'A']--;
                    cnt++;
                }
            }
            if(s.length() == input.length() && 
                    (s.length() == cnt || s.length() - 1 == cnt)) result++;
            else if(s.length() == input.length() - 1 && input.length() - 1 == cnt) result++;
            else if(s.length() == input.length() + 1 && input.length() == cnt) result++;
        }
        bw.write(result + "");
        bw.flush();
    }
}