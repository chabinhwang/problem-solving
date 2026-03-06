import java.io.*;
import java.util.*;

public class Main {
    static int[][] dp; // [r][c] : 해당 row/col에서 목적지까지 가는 경우의 수
    static int[][] map; // 지도
    static int M; // row
    static int N; // col
    static int[] dr = { -1, 0, 1, 0 };
    static int[] dc = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        dp = new int[M][N];
        map = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 0; i < M; i++){
            Arrays.fill(dp[i], -1);
        }
        System.out.println(DFS(0, 0));
    }

    static int DFS(int row, int col) {
        int height = map[row][col];
        if (row == M - 1 && col == N - 1)
            return 1; // 현 위치가 목적지라면 1 return
        if(dp[row][col] != -1) return dp[row][col];
        dp[row][col] = 0; // 계산 전 DP값 0으로 초기화
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            // 현위치보다 아래라고 판단 시, DFS
            if (nr >= 0 && nc >= 0 && nr < M && nc < N && height > map[nr][nc]) {
                dp[row][col] += DFS(nr, nc); // 해당 방향 가는 경로: [row][col] 에서 건너가는 경우 추가
            }
        }
        return dp[row][col];
    }
}