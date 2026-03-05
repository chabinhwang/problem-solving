import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    static int[][][] dp;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[1 << N][N][10]; // dp[bitmask][현재 그림 소유자][그림 구매했던 가격]
        arr = new int[N][N];

        // 산 가격보다 같거나 비싸게 팔아야 함
        // 같은 그림 2번 이상 구매 불가
        for (int i = 0; i < N; i++) {
            // i번째 줄의 j번째 수는 j번 예술가가 i번 예술가에게 그 그림을 살 때의 가격
            // rowIdx : 판매자, colIdx: 구매자
            String[] s = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(s[j]);
            }
        }
        for (int i = 0; i < (1 << N); i++)
            for (int j = 0; j < N; j++)
                Arrays.fill(dp[i][j], -1);
        System.out.println(DFS(1, 0, 0) + 1);
    }

    static int DFS(int bitmask, int cur, int price) { // cur는 현재 그림 소유자, price 는 현재 거래 가격
        if (dp[bitmask][cur][price] != -1)
            return dp[bitmask][cur][price];

        int[] nextPrice = arr[cur];

        int res = 0;
        // 더 내려갈 곳 없으면 아래 for문 안돌음.
        for (int i = 0; i < N; i++) {
            if (nextPrice[i] >= price && (bitmask & (1 << i)) == 0) { // price보다 높으면서, i가 거래하지 않은 사람일 때
                res = Math.max(res, 1 + DFS(bitmask | (1 << i), i, nextPrice[i]));
            }
        }
        dp[bitmask][cur][price] = res;
        return res;
    }
}
