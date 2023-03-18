import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++){
            int kg = arr[i][0];
            int cm = arr[i][1];
            int count = 0;
            for(int j = 0; j < N; j++) {
                if(kg < arr[j][0] && cm < arr[j][1]) count++;
            }
            System.out.print((count + 1) + " ");
        }
        br.close();
    }
}