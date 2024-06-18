import java.io.*;
import java.util.*;

public class Main {
    
    public static class Player implements Comparable<Player> {
        int level;
        String name;
        boolean check;

        Player(int level, String name) {
            this.level = level;
            this.name = name;
            check = false;
        }

        @Override
        public int compareTo(Player o) {
            return name.compareTo(o.name);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Player[] players = new Player[p];
        for(int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            players[i] = new Player(level, name);
        }
        for(int i = 0; i < p; i++) {
            ArrayList<Player> room = new ArrayList<>();
            if(!players[i].check) {
                for(int j = i; j < p; j++) {
                    if(room.size() == m) break;
                    int level = players[j].level;
                    String name = players[j].name;
                    if(!players[j].check && players[i].level - 10 <= level && players[i].level + 10 >= level) {
                        players[j].check = true;
                        room.add(new Player(level, name));
                    }
                }
                Collections.sort(room);
                if(room.size() == m) bw.write("Started!\n");
                else bw.write("Waiting!\n");
                for(Player player: room) {
                    bw.write(player.level + " " + player.name + "\n");
                }
            }
        }
        bw.flush();
    }
}