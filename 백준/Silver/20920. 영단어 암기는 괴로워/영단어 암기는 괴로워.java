import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            String s = br.readLine();
            if(s.length() < m) continue;
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        // map value 내림차순 정렬
        List<String> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 자주 등장하는 단어 순서대로 정렬 
                if (Integer.compare(map.get(o1), map.get(o2)) != 0) {
                    return Integer.compare(map.get(o2), map.get(o1));
                }
                // 등장 횟수가 같으면 길이가 긴 단어가 먼저 오도록 정렬
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                // 등장 횟수와 길이가 같으면 사전 순으로 정렬
                return o1.compareTo(o2);
            }
        });
        for(int i = 0; i < map.size(); i++) {
            if(i == map.size() - 1) bw.write(keySet.get(i));
            else bw.write(keySet.get(i) + "\n");
        }
        bw.flush();
    }
}