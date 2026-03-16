import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static boolean[][] visit;
    static int top = 0; // 최대 높이
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, -1, 0, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int a = Integer.parseInt(st.nextToken());
                map[i][j] = a;
                top = Math.max(a, top);
            }
        }

        int result = 0;
        for (int k = 0; k < top; k++) {
            visit = new boolean[N][N];
            int temp = 0;
            // k 보다 낮은 높이는 전부 잠김 처리
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    // k보다 높으면서, 방문 안한 노드만 방문
                    if (map[i][j] > k && !visit[i][j]) {
                        DFS(i, j, k);
                        temp += 1;
                    }
                }
            }
            result = Math.max(result, temp);
        }

        System.out.println(result);
    }

    // r : row, c: col, f: 잠긴 수위
    static void DFS(int r, int c, int f) {
        visit[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (nr < N && nc < N && nr >= 0 && nc >= 0 && map[nr][nc] > f && !visit[nr][nc]) {
                DFS(nr, nc, f);
            }
        }
        return;
    }
}
