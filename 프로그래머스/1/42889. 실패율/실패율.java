import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] current = new int[N + 1];
        int[] clear = new int[N + 1];
        for(int i = 0; i < stages.length; i++) {
            int n = stages[i];
            if(n <= N) current[n]++;
            else n--;
            for(int j = 1; j <= n; j++) clear[j]++;
        }
        Map<Integer, Double> map = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            if(current[i] == 0 || clear[i] == 0) map.put(i, 0.0);
            else map.put(i, (double)current[i] / clear[i]);
            System.out.println(i + " " + map.get(i));
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) -> Double.compare(map.get(o2), map.get(o1)));
        return list.stream().mapToInt(i -> i).toArray();
    }
}