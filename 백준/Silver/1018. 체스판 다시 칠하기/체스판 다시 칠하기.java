import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static char arr[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        arr = new char[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        int result = 1000000;
        for(int i = 0; i < N - 7; i++) {
            for(int j = 0; j < M - 7; j++) {
                result = Math.min(result, count(i, j));
            }
        }
        System.out.println(result);
        br.close();
    }

    public static int count(int x, int y) {
        int B = 0; // B부터 시작
        int W = 0; // W부터 시작
        for(int i = x; i < x + 8; i++) {
            for(int j = y; j < y + 8; j++) {
                if((i + j) % 2 == 0) {
                    if(arr[i][j] == 'B') W++;
                    else B++;
                } else {
                    if(arr[i][j] == 'W') W++;
                    else B++;
                }
            }
        }
        return Math.min(B, W);
    }
}