import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = {};
        List<Integer> list = new ArrayList<>();
        list.add(k);
        while(k > 1){
            if(k % 2 == 1){
                k = k * 3 + 1;
                list.add(k);
            }
            else{
                k /= 2;
                list.add(k);
            }
        }
        
        List<Double> area = new ArrayList<>();
        for(int i = 0; i < list.size() - 1; i++){
            double a = (list.get(i) + list.get(i + 1)) / 2.0;
            area.add(a);
        }
        int idx = 0;
        answer = new double[ranges.length];
        for(int[] r: ranges){
            int x1 = r[0];
            int x2 = list.size() - 1 + r[1];
            if(x1 > x2){
                answer[idx++] = -1;
                continue;
            }
            double sum = 0;
            for(int i = x1; i < x2; i++){
                sum += area.get(i);
            }
            answer[idx++] = sum;
        }
        return answer;
    }
}