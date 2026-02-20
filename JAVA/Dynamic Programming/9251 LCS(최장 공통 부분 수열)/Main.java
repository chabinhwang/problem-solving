import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fst = br.readLine().split("");
        String[] sec = br.readLine().split("");
        int[][] dp = new int[fst.length + 1][sec.length + 1];
        // dp[i][j]는 first의 i 인덱스까지 + second 의 j 인덱스까지 중 같은 원소 최대갯수
        for (int i = 0; i < fst.length + 1; i++) {
            for (int j = 0; j < sec.length + 1; j++) {
                if (i == 0 || j == 0){// row가 0이거나, col이 0인 경우의 dp값을 모두 0으로 초기화
                    dp[i][j] = 0;
                    continue;
                }

                if (fst[i-1].equals(sec[j-1]))
                    dp[i][j] = dp[i - 1][j - 1] + 1; // i번째와 j번째가 같은 경우
                else
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
            }
        }
        System.out.println(dp[fst.length][sec.length]);
    }
}
