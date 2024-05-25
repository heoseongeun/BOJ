import java.io.*;
import java.util.*;

public class Main {
    static int[] arr;
    static boolean[] robot;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        arr = new int[2 * n];
        robot = new boolean[n];
        for(int i = 0; i < 2 * n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int step = 0;
        while(0 < k) {
            // 벨트와 함께 로봇 회전
            int tmp = arr[arr.length - 1];
            int idx = n - 1;
            for(int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
                if(idx > 0) {
                    robot[idx] = robot[idx - 1];
                    idx--;
                }
            }
            arr[0] = tmp;
            robot[0] = false;
            robot[n - 1] = false;
            // 로봇 회전
            for(int i = n - 1; i > 0; i--) {
                if(robot[i - 1] && !robot[i] && arr[i] >= 1) {
                    arr[i]--;
                    if(arr[i] == 0) k--;
                    robot[i] = true;
                    robot[i - 1] = false;
                }
            }
            if(arr[0] > 0) {
                robot[0] = true;
                arr[0]--;
                if(arr[0] == 0) k--;
            }
            step++;
        }
        bw.write(step + "");
        bw.flush();
    }
}