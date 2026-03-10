import java.util.*;
import java.io.*;

public class Main {
    static int[][] map;
    static int[][] dp; // 판다가 (a, b)에서 얼마나 더 갈 수 있는지 저장
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, -1, 0, 1 };
    static int max = Integer.MIN_VALUE;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int input = Integer.parseInt(st.nextToken());
                map[i][j] = input;
                dp[i][j] = 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = DFS(i, j);
            }
        }
        System.out.println(max);
    }

    static int DFS(int r, int c) {
        if (dp[r][c] != 0) { // dp값이 저장된 게 있는 경우 해당 값 반환.
            return dp[r][c];
        } else {
            int t = 0;

            for (int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && map[r][c] > map[nr][nc]) {
                    t = Math.max(t, DFS(nr, nc));
                }
            }
            dp[r][c] = t + 1;
            max = Math.max(dp[r][c], max);
            return dp[r][c];
        }

    }
}
