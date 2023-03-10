import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        int[] count = new int[3];
        int n1 = 0, n2 = 0, n3 = 0;
        int[] first = new int[]{1, 2, 3, 4, 5};
        int[] second = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] third = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == first[n1++ % 5]) count[0]++;
            if(answers[i] == second[n2++ % 8]) count[1]++;
            if(answers[i] == third[n3++ % 10]) count[2]++;
        }
        int max = Arrays.stream(count).max().getAsInt();
        for(int i = 0; i < count.length; i++) {
            if(max == count[i]) list.add(i + 1);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}