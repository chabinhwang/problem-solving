import java.util.*;
import java.io.*;

public class Main {
    // 0번 은 0을 리턴함. dp0[0] = 1 이란 뜻
    public static int[] dp0; // idx 번 숫자에 0이 얼마나 나타나는 지
    public static int[] dp1; // idx 번 숫자에 1이 얼마나 나타나는 지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        dp0 = new int[41];
        dp1 = new int[41];
        dp0[0] = 1;
        dp1[0] = 0;

        dp0[1] = 0;
        dp1[1] = 1;
        // 2는 1과 0을 활용, 1은 1 반환, 0은 0 반환, 따라서 2는 1 반환
        dp0[2] = 1;
        dp1[2] = 1;
        // 3은 2번째 + 1번쨰, 2번째에서 1은 2개 반환, 0은 1개 반환. 1번째에서
        dp0[3] = 1;
        dp1[3] = 2;

        // i 번째 숫자의 0이 출력되는 횟수는 , i-1, i-2의 0출력 횟수의 합임. 이를 40까지 하면 됨.
        for (int i = 4; i < 41; i++) {
            dp0[i] = dp0[i - 1] + dp0[i - 2];
            dp1[i] = dp1[i - 1] + dp1[i - 2];
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); // N은 N번째 피보나치 수
            sb.append(String.valueOf(dp0[N]) + " " + String.valueOf(dp1[N])+"\n");
        }
        System.out.println(sb);
    }
}
