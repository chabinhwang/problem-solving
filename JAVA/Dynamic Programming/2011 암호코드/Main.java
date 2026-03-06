import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] c = br.readLine().toCharArray();
        long[] dp = new long[c.length + 1]; // dp[i] = i번째 숫자까지 사용했을 때 나욜 수 있는 문자의 경우의 수
        dp[0] = 1;
        dp[1] = (c[0] == '0') ? 0 : 1;
        for (int i = 2; i <= c.length; i++) {
            int one = c[i - 1] - '0';
            int two = (c[i - 2] - '0') * 10 + one;
            if (one >= 1) dp[i] += dp[i - 1];
            if (two >= 10 && two <= 26) dp[i] += dp[i - 2];
            dp[i] %= 1_000_000;
        }
        System.out.println(dp[c.length] % 1_000_000);
    }
}