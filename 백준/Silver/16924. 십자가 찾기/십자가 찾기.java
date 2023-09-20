import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] arr = new char[N][M];
        boolean[][] visited = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            String s = br.readLine();
            for(int j = 0; j < M; j++) arr[i][j] = s.charAt(j);
        }
        ArrayList<int[]> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                int size = 0;
                if(arr[i][j] == '*') {
                    for(int k = 1; ; k++) {
                        if(i - k >= 0 && i + k < N && j - k >= 0 && j + k < M) {
                            if(arr[i - k][j] == '*' && arr[i + k][j] == '*'
                            && arr[i][j - k] == '*' && arr[i][j + k] == '*') {
                                size = k;
                            } else break;
                        } else break;
                    }
                }
                if(size > 0) {
                    list.add(new int[]{i + 1, j + 1, size});
                    visited[i][j] = true;
                    for(int k = 1; k <= size; k++) {
                        visited[i + k][j] = true;
                        visited[i - k][j] = true;
                        visited[i][j + k] = true;
                        visited[i][j - k] = true;
                    }
                }
            }
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == '*' && visited[i][j] == false) {
                    System.out.println(-1);
                    System.exit(0);
                }
            }
        }
        System.out.println(list.size());
        for(int[] a: list) 
            System.out.println(a[0] + " " + a[1] + " " + a[2] + " ");
        br.close();
    }
}