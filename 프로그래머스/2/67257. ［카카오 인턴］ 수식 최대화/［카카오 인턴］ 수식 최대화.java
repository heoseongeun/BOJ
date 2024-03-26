import java.util.*;

class Solution {
    static ArrayList<Long> num = new ArrayList<>();
    static ArrayList<Character> oper = new ArrayList<>();
    static Set<Character> set = new HashSet<>();
    static char[] op, perm;
    static boolean[] visited;
    static long answer = 0;
    static int n; // 연산자 개수

    public long solution(String expression) {
        int idx = 0;
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if(c == '-' || c == '+' || c == '*') {
                num.add(Long.parseLong(expression.substring(idx, i)));
                oper.add(c);
                set.add(c);
                idx = i + 1;
            }
        }
        num.add(Long.parseLong(expression.substring(idx)));
        n = set.size();
        idx = 0;
        op = new char[n];
        perm = new char[n];
        visited = new boolean[n];
        for(char c: set) op[idx++] = c;
        perm(0);
        return answer;
    }

    static void perm(int depth) { // 순열
        if(depth == n) {
            sol();
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]) {
                visited[i] = true;
                perm[depth] = op[i];
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }

    static void sol() {
        ArrayList<Character> operator = new ArrayList<Character>();
        operator.addAll(oper);
        ArrayList<Long> number = new ArrayList<Long>();
        number.addAll(num);
        for(int i = 0; i < n; i++) {
            char op = perm[i];
            for(int j = 0; j < operator.size(); j++) {
                if(operator.get(j) == op) {
                    long n1 = number.get(j);
                    long n2 = number.get(j + 1);
                    long res = cal(n1, n2, op);
                    number.remove(j + 1);
                    number.remove(j);
                    operator.remove(j);
                    number.add(j, res);
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(number.get(0)));
    }

    static long cal(long n1, long n2, char op) {
        long res = 0;
        switch(op) {
            case '*':
                res = n1 * n2;
                break;
            case '+':
                res = n1 + n2;
                break;
            case '-':
                res = n1 - n2;
                break;
        }
        return res;
    }
}