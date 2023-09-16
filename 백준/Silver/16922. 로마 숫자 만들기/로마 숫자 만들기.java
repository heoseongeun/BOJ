import java.io.*;

public class Main {
    static int N;
    static boolean[] visited = new boolean[1001];
    static int[] nums = new int[]{1, 5, 10, 50};
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        dfs(0, 0, 0);
        bw.write(result + "");
        br.close();
        bw.close();
    }

    static void dfs(int depth, int index, int sum) {
        if(depth == N) {
            if(!visited[sum]) {
                visited[sum] = true;
                result++;
            }
            return;
        }
        for(int i = index; i < 4; i++) 
            dfs(depth + 1, i, sum + nums[i]);
    }
}