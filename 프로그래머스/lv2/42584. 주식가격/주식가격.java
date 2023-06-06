import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int n = prices.length;
        int[] answer = new int[n];
        Stack<Integer[]> stack = new Stack<>();
        for(int i = 0; i < n; i++){
            answer[i] = n - 1 - i;
            Integer[] arr = {i, prices[i]};
            while(!stack.empty() && stack.peek()[1] > prices[i]){
                Integer[] price = stack.pop();
                answer[price[0]] = i - price[0];
            }            
            stack.push(arr);
        }
        return answer;
    }
}