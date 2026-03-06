import java.io.*;
import java.util.*;

public class Main {
    static int k;
    static int[] dp;// dp[완성하는 목표 금액] = (시그마) "완성금액보다 낮은 코인들을 완성금액에서 뺀 dp값"
    static int[] coinArr; // 동전 가격 정렬(예: 1원 5원 10원 동전이 있다면, [10,5,1])

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken()); // 가치의 합이 k원
        coinArr = new int[n + 1];
        dp = new int[k+1];
        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            coinArr[i] = coin;
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin];
            }
        }
        System.out.println(dp[k]);
    }
}