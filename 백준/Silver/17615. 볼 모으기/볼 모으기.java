import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        // 빨간색 왼쪽
        int cnt = 0, result = Integer.MAX_VALUE;
        boolean check = false;
        for(int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if(check && c == 'R') cnt++;
            if(c == 'B') check = true;
        }
        result = Math.min(result, cnt);
        cnt = 0; check = false;
        // 빨간색 오른쪽
        for(int i = n - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if(check && c == 'R') cnt++;
            if(c == 'B') check = true;
        }
        result = Math.min(result, cnt);
        cnt = 0; check = false;
        // 파란색 왼쪽
        for(int i = 0; i < n; i++) {
            char c = input.charAt(i);
            if(check && c == 'B') cnt++;
            if(c == 'R') check = true;
        }
        result = Math.min(result, cnt);
        cnt = 0; check = false;
        // 파란색 오른쪽
        for(int i = n - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if(check && c == 'B') cnt++;
            if(c == 'R') check = true;
        } 
        result = Math.min(result, cnt);
        bw.write(result + "");
        bw.flush();
    }
}