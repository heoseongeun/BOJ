import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        boolean[] arr = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            if(st.nextToken().equals("1")) {
                arr[i] = true;
            } else arr[i] = false;
        }
        int student = Integer.parseInt(br.readLine());
        for(int i = 0; i < student; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            if(gender == 1) { // 남학생
                for(int j = num; j <= n; j += num) {
                    arr[j] = !arr[j];
                }
            } else { // 여학생
                int idx = 1;
                arr[num] = !arr[num];
                while (true) {
                    if(num - idx >= 1 && num + idx <= n && (arr[num - idx] == arr[num + idx])) {
                        arr[num + idx] = !arr[num + idx];
                        arr[num - idx] = !arr[num - idx];
                        idx++;
                    }
                    else break;
                }
            }
        }
        // 출력
        for(int i = 1; i <= n; i++) {
            if(arr[i]) bw.write("1");
            else bw.write("0");
            if(i % 20 != 0 && i != n) bw.write(" ");
            if(i % 20 == 0) bw.write("\n");
        }
        bw.flush();
    }
}