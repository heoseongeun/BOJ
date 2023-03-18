import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        Set<Integer> card = new HashSet<>();
        for(int i = 0; i < N; i++) {
            card.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            if(card.contains(Integer.parseInt(st.nextToken()))) System.out.print(1 + " ");
            else System.out.print(0 + " ");
        }
        br.close();
    }
}