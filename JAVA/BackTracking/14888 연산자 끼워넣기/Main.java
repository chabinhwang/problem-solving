import java.util.*;
import java.io.*;

public class Main {
    static boolean[] hasSymbol = new boolean[4];// 덧셈,뺄셈,곱하기,나누기(몫) 기호 존재 여부
    static int[] symbols = new int[4];
    static int[] nums;
    static int N;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nums = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 4; i++) {
            symbols[i] = Integer.parseInt(st.nextToken());
            if (symbols[i] != 0) {
                hasSymbol[i] = true;
            }
        }
        DFS(0, nums[0]);
        System.out.printf("%d\n%d", max, min);
    }

    // 나눗셈은 몫만
    static void DFS(int idx, int value) {

        for (int i = 0; i < 4; i++) {
            int nValue = value;
            if (hasSymbol[i]) { // i번째 연산자 있을 때 -> 연산해서 다음으로 value넘기기
                if (i == 0) {// +
                    nValue = value + nums[idx + 1];
                } else if (i == 1) {// -
                    nValue = value - nums[idx + 1];
                } else if (i == 2) {// *
                    nValue = value * nums[idx + 1];
                } else {// /
                    nValue = value / nums[idx + 1];
                }
                symbols[i] -= 1;
                if (symbols[i] == 0) {
                    hasSymbol[i] = false;
                }
                DFS(idx + 1, nValue);
                symbols[i] += 1;
                if (symbols[i] == 1) {
                    hasSymbol[i] = true;
                }
            }
            if (idx == N - 1) {
                max = Math.max(max, value);
                min = Math.min(min, value);
                return;
            }
        }
    }
}
