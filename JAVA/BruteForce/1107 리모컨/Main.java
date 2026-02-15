import java.io.*;
import java.util.*;

public class Main {
    static Set<Integer> broken = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        if (M > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) broken.add(Integer.parseInt(st.nextToken()));
        }

        int ans = Math.abs(N - 100); // +/-만 쓰는 경우

        // N 최대 500,000이라 보통 1,000,000까지 보면 충분합니다.
        for (int ch = 0; ch <= 1_000_000; ch++) {
            int len = typeLengthIfPossible(ch);
            if (len >= 0) {
                int press = len + Math.abs(ch - N);
                ans = Math.min(press, ans);
            }
        }

        System.out.println(ans);
    }

    // 입력 가능하면 "누른 숫자 버튼 개수" 반환, 불가능하면 -1
    static int typeLengthIfPossible(int x) {
        if (x == 0) {
            return broken.contains(0) ? -1 : 1;
        }
        int len = 0;
        while (x > 0) {
            int d = x % 10;
            if (broken.contains(d)) return -1;
            len++;
            x /= 10;
        }
        return len;
    }
}