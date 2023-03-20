import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            for(int j = 2; j < n; j++) {
                if(isPrime(j)) list.add(j);
            }
            int p1 = 0;
            int p2 = 0;
            for(int k = 0; k < list.size(); k++) {
                for(int i = k; i < list.size(); i++) {
                    if(list.get(k) + list.get(i) == n) {
                        p1 = list.get(k);
                        p2 = list.get(i);
                        break;
                    }
                }
            }
            System.out.println(p1 + " " + p2);
        }
        br.close();
    }

    public static boolean isPrime(int n) {
        if(n == 2) return true;
        if(n % 2 == 0 || n < 2) return false;
        boolean check = true;
        for(int j = 3; j <= Math.sqrt(n); j += 2) {
            if(n % j == 0) {
                check = false;
                break;
            }
        }
        return check;
    }
}