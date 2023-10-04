import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr, dist;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int eat = 0, size = 2, cnt = 0;
    static int N, x, y, minDist, minX, minY;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < N; j++) {
                int n = Integer.parseInt(st.nextToken());
                arr[i][j] = n;
                if(n == 9) {
                    x = i;
                    y = j;
                    arr[i][j] = 0;
                }
            }
        }
        while(true) {
            dist = new int[N][N];
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            minDist = Integer.MAX_VALUE;
            bfs(x, y);
            if(minX != Integer.MAX_VALUE && minY != Integer.MAX_VALUE) {
                eat++;
                arr[minX][minY] = 0;
                x = minX;
                y = minY;
                cnt += dist[minX][minY];
                if(eat == size) {
                    size++;
                    eat = 0;
                }
            } else break;
        }
        bw.write(cnt + "");
        br.close();
        bw.close();
    }

    static void bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y));
        while(!q.isEmpty()) {
            Pos p = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if(isArea(nx, ny) && arr[nx][ny] <= size && dist[nx][ny] == 0) {
                    dist[nx][ny] = dist[p.x][p.y] + 1;
                    if(arr[nx][ny] != 0 && arr[nx][ny] < size) {
                        if(minDist > dist[nx][ny]) {
                            minDist = dist[nx][ny];
                            minX = nx;
                            minY = ny;
                        } else if(minDist == dist[nx][ny]) {
                            if(minX == nx) {
                                if(minY > ny) {
                                    minX = nx;
                                    minY = ny;
                                }
                            } else if(minX > nx) {
                                minX = nx;
                                minY = ny;
                            }
                        }
                    }
                    q.add(new Pos(nx, ny));
                }
            }
        }
    }

    static boolean isArea(int x, int y) {
        if(x >= 0 && x < N && y >= 0 && y < N) return true;
        return false;
    }

    static class Pos {
        int x, y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}