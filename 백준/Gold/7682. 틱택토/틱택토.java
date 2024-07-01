import java.io.*;

public class Main {
    static char[][] arr = new char[3][3];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while(true) {
            String s = br.readLine();
            if(s.equals("end")) break;
            int o = 0, x = 0;
            for(int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if(c == 'O') o++;
                else if(c == 'X') x++;
                arr[i / 3][i % 3] = c;
            }
            if(x == o) { // o가 이긴 경우
                if(!bingo('X') && bingo('O')) bw.write("valid\n");
                else bw.write("invalid\n");
            } else if(x == o + 1) { // x가 이긴 경우
                if(x + o == 9 && !bingo('O')) bw.write("valid\n");
                else if(!bingo('O') && bingo('X')) bw.write("valid\n");
                else bw.write("invalid\n");
            } else bw.write("invalid\n");
        }
        bw.flush();
    }

    public static boolean bingo(char c) {
        for(int i = 0; i < 3; i++) { // 가로
            if(arr[i][0] == c && arr[i][1] == c && arr[i][2] == c) return true;
        }
        for(int i = 0; i < 3; i++) { // 세로
            if(arr[0][i] == c && arr[1][i] == c && arr[2][i] == c) return true;
        }
        // 대각선
        if(arr[0][0] == c && arr[1][1] == c && arr[2][2] == c) return true;
        if(arr[0][2] == c && arr[1][1] == c && arr[2][0] == c) return true;
        return false;
    }
}