import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] plus = new int[4001];
        int[] minus = new int[4001];
        int sum = 0;
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            sum += n;
            arr[i] = n;
            if(n < 0) minus[-n]++;
            else plus[n]++;
        }
        int max = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < 4001; i++) {
            max = Math.max(max, Math.max(plus[i], minus[i]));
        }
        Arrays.sort(arr);
        for(int i: arr) {
            if(i < 0) {
                if(minus[Math.abs(i)] == max && !(list.contains(i))) list.add(i);
            } else {
                if(plus[i] == max && !(list.contains(i))) list.add(i);
            }
        }
        int result = 0;
        if(list.size() > 1) result = list.get(1);
        else result = list.get(0);
        System.out.println(Math.round((double)sum / N));
        System.out.println(arr[arr.length / 2]);
        System.out.println(result);
        System.out.println(arr[arr.length - 1] - arr[0]);
        br.close();
    }
}