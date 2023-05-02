import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[N];
        int[] dp = new int[N];
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        int max = -1;
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            arrayList.add(new ArrayList<>());
        }
        int index = 0;
        for(int i = 0; i < N; i++) {
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                    arrayList.get(i).add(arr[j]);
                }
            }
            max = Math.max(dp[i], max);
        }
        bw.write(max + "\n");
        int value = max;
        Stack<Integer> stack = new Stack<>();
        for(int i = N - 1; i >= 0; i--) {
            if(value == dp[i]) {
                stack.push(arr[i]);
                value--;
            }
        }
        while(!stack.isEmpty()) bw.write(stack.pop() + " ");
        bw.flush();
        bw.close();
        br.close();
    }
}