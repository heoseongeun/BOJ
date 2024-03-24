import static java.util.Arrays.*;
import static java.util.stream.Collectors.*;

import java.util.*;
import java.io.*;

class Solution {
    ArrayList<ArrayList<Node>> list = new ArrayList<>();
    public int solution(int N, int[][] road, int K) {
        for(int i = 0; i < N + 1; i++) list.add(new ArrayList<>());
        for(int i = 0; i < road.length; i++) {
            int[] edge = road[i];
            list.get(edge[0]).add(new Node(edge[1], edge[2]));
            list.get(edge[1]).add(new Node(edge[0], edge[2]));
        }
        int answer = dijkstra(1, list, K);
        return answer;
    }
    
    int dijkstra(int start, ArrayList<ArrayList<Node>> graph, int k) {
        int[] distance = new int[graph.size()];
        Arrays.fill(distance,Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.weight - o2.weight);
        distance[start] = 0;
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            if(distance[cur.node] < cur.weight) continue;
            for (Node next : graph.get(cur.node)) {
                if(distance[next.node] > distance[cur.node] + next.weight){
                    distance[next.node] = distance[cur.node] + next.weight;
                    pq.add(new Node(next.node, distance[next.node]));
                }
            }
        }
        return (int)stream(distance).filter(dist -> dist <= k).count();
    }
    
    static class Node{
        int node, weight;
        public Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }
}