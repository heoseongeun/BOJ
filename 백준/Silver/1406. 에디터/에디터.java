import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        int M = Integer.parseInt(br.readLine());
        LinkedList<Character> list = new LinkedList<>();
        String str;
        for(int i = 0; i < input.length(); i++) list.add(input.charAt(i));
        ListIterator<Character> iter = list.listIterator();
        while(iter.hasNext()) iter.next();
        for(int i = 0; i < M; i++) {
            str = br.readLine();
            char c = str.charAt(0);
            if(c == 'L') {
                if(iter.hasPrevious()) iter.previous();
            } else if(c == 'D') {
                if(iter.hasNext()) iter.next();
            } else if(c == 'B') {
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }
            } else if(c == 'P') {
                iter.add(str.charAt(2));
            }
        }
        for(Character c: list) bw.write(c);
        bw.flush();
        br.close();
    }
}