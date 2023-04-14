import java.util.*;

class Solution {
    public static int[] parent;
    
    public int solution(int n, int[][] wires) {
        int answer = 100;
        parent = new int[n + 1];
        
        for(int i = 0; i < wires.length; i++) {
            for(int k = 0; k < n + 1; k++) parent[k] = k;
            for(int k = 0; k < wires.length; k++) {
                if(i == k) continue; // 전선 끊기
                union(wires[k][0], wires[k][1]);
            }
            int size = 0;
            for(int k = 1; k < n + 1; k++) {
                if(find(parent[k]) != 1) size++;
            }
            answer = Math.min(answer, Math.abs(n - size * 2));
        }
        return answer;
    }
    
    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a <= b) parent[b] = a;
        else parent[a] = b;
    }
    
    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}