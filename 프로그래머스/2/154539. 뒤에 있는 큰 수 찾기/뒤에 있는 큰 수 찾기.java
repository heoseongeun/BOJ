import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < n; i++) {
            if(!stack.isEmpty()) {
                while(!stack.isEmpty()) {
                    if(numbers[stack.peek()] < numbers[i])
                        answer[stack.pop()] = numbers[i];
                    else break;
                }
            }
            stack.add(i);
        }
        return answer;
    }
}