import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] prime = new boolean[1000001];
        prime[0] = prime[1] = true; // 소수 : false
        for(int i = 2; i * i < prime.length; i++) {
            if(!prime[i]) { // prime[i]가 소수라면
                for(int j = i * i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }

        int input = Integer.parseInt(br.readLine());
        while(input != 0) {
            boolean check = false;
            for(int i = 2; i <= input / 2; i++) {
                if(!prime[i] && !prime[input - i]) {
                    bw.write(input + " = " + i + " + " + (input - i) + "\n");
                    check = true;
                    break;
                }
            }
            if(!check) bw.write("Goldbach's conjecture is wrong.");
            input = Integer.parseInt(br.readLine());
        }
        bw.flush();
    }
}