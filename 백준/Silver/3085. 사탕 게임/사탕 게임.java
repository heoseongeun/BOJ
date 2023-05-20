import java.io.*;

public class Main {
    public static int n;
    public static char[][] arr;
    public static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());
        arr = new char[n][n];
        for(int i = 0; i < n; i++) {
            String str = br.readLine();
            for(int j = 0; j < n; j++) arr[i][j] = str.charAt(j);
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                char tmp = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = tmp;
                check();
                tmp = arr[i][j];
                arr[i][j] = arr[i][j + 1];
                arr[i][j + 1] = tmp;
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n - 1; j++) {
                char tmp = arr[j][i];
                arr[j][i] = arr[j + 1][i];
                arr[j + 1][i] = tmp;
                check();
                tmp = arr[j][i];
                arr[j][i] = arr[j + 1][i];
                arr[j + 1][i] = tmp;
            }
        }
        bw.write(max + "");
        bw.flush();
        bw.close();
        br.close();
    }

    public static void check() {
        // 가로
        for(int i = 0; i < n; i++) {
            int count = 1;
            for(int j = 0; j < n - 1; j++) {
                if(arr[i][j] == arr[i][j + 1]) count++;
                else count = 1;
                max = Math.max(max, count);
            }
        }
        // 세로
        for(int i = 0; i < n; i++) {
            int count = 1;
            for(int j = 0; j < n - 1; j++) {
                if(arr[j][i] == arr[j + 1][i]) count++;
                else count = 1;
                max = Math.max(max, count);
            }
        }
    }
}