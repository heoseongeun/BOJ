import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] rank = new int[n];
            Map<Integer, Integer> map = new HashMap<>();
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                map.put(num, map.getOrDefault(num, 0) + 1);
                rank[j] = num;
            }
            // 참가 선수 계산
            Map<Integer, Integer> score = new HashMap<>();
            Map<Integer, Integer> temp = new HashMap<>();
            int[] fifth = new int[map.size() + 1];
            int idx = 1;
            for(int elem: rank) {
                if(map.get(elem) >= 6) {
                    // 참가 선수가 여섯명인 팀의 점수
                    temp.put(elem, temp.getOrDefault(elem, 0) + 1);
                    if(temp.get(elem) <= 4) {
                        score.put(elem, score.getOrDefault(elem, 0) + idx);
                    }
                    if(temp.get(elem) == 5) {
                        fifth[elem] = idx;
                    }
                    idx++;
                }
            }
            // 오름차순 정렬
            List<Integer> key = new ArrayList<>(score.keySet());
            key.sort((x, y) -> {
                if (Objects.equals(score.get(x), score.get(y))){
                    return fifth[x] - fifth[y];
                } else {
                    return score.get(x) - score.get(y);
                }
            });
            if(i == t - 1) bw.write(key.get(0) + "");
            else bw.write(key.get(0) + "\n");
        }
        bw.flush();
    }
}