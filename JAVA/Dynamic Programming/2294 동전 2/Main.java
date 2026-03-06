import java.io.*;
import java.util.*;

public class Main {
    static int k; // 목표 가격
    static int[] dp; // idx 가격 만드는 데 사용하는 코인 최소 갯수
    static Set<Integer> set = new HashSet<Integer>(); // 해당 동전으로 이미 연산했는지 확인하는 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[k + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int coin = Integer.parseInt(br.readLine());
            if (set.contains(coin))
                continue;
            set.add(coin);

            for (int j = coin; j <= k; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
            }
        }
        if (dp[k] == Integer.MAX_VALUE) {

            System.out.println(-1);
        } else {

            System.out.println(dp[k]);
        }
    }
}