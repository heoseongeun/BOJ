import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int left;
        int right;
        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static int N;
    static List<Node>[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N + 1];
        for(int i = 1; i < N + 1; i++) list[i] = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int root = st.nextToken().charAt(0) - 'A' + 1;
            int left = st.nextToken().charAt(0) - 'A' + 1;
            int right = st.nextToken().charAt(0) - 'A' + 1;
            list[root].add(new Node(left, right));
        }
        preorder(1);
        sb.append("\n");
        inorder(1);
        sb.append("\n");
        postorder(1);
        bw.write(sb.toString());
        bw.close();
        br.close();
    }

    static void preorder(int start) { // root left right
        for(Node node: list[start]) {
            int left = node.left;
            int right = node.right;
            sb.append((char)(start + 'A' - 1));
            if(left != -18) preorder(left);
            if(right != -18) preorder(right);
        }
    }

    static void inorder(int start) { // left root right
        for(Node node: list[start]) {
            int left = node.left;
            int right = node.right;
            if(left != -18) inorder(left);
            sb.append((char)(start + 'A' - 1));
            if(right != -18) inorder(right);
        }
    }

    static void postorder(int start) { // left right root
        for(Node node: list[start]) {
            int left = node.left;
            int right = node.right;
            if(left != -18) postorder(left);
            if(right != -18) postorder(right);
            sb.append((char)(start + 'A' - 1));
        }
    }
}