import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] fst = br.readLine().split("");
        String[] sec = br.readLine().split("");
        int[][] dp = new int[fst.length + 1][sec.length + 1];
        // dp[i][j]는 first의 i 인덱스까지 + second 의 j 인덱스까지 중 같은 원소 최대갯수
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < fst.length + 1; i++) {
            for (int j = 0; j < sec.length + 1; j++) {
                if (i == 0 || j == 0) {// row가 0이거나, col이 0인 경우의 dp값을 모두 0으로 초기화
                    dp[i][j] = 0;
                    continue;
                }

                if (fst[i - 1].equals(sec[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1; // i번째와 j번째가 같은 경우
                } else
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        bw.write(String.valueOf(dp[fst.length][sec.length]));
        bw.newLine();
        bw.flush();
        if(dp[fst.length][sec.length] == 0)return;

        int row = fst.length;
        int col = sec.length;
        StringBuilder sb = new StringBuilder();
        while (row > 0 && col > 0) {
            if (fst[row - 1].equals(sec[col - 1])) {
                sb.append(fst[row - 1]);
                row -= 1;
                col -= 1;
            } else if (dp[row - 1][col] >= dp[row][col - 1]) {
                row -= 1;
            } else {
                col -= 1;
            }
        }
        bw.write(sb.reverse().toString());
        bw.flush();
        bw.close();
    }
}
