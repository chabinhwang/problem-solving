import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] nums = new String[N];
        for (int i = 0; i < N; i++) {
            nums[i] = br.readLine().trim();
        }

        int K = Integer.parseInt(br.readLine());

        //36^p 값을 미리 저장
        BigInteger[] pow36 = new BigInteger[55];
        pow36[0] = BigInteger.ONE;
        for (int i = 1; i < pow36.length; i++) {
            pow36[i] = pow36[i - 1].multiply(BigInteger.valueOf(36));
        }

        //각 문자에 대해 ‘Z’로 교체했을 때 얻는 이득(benefit)을 누적 
        BigInteger[] benefit = new BigInteger[36];
        Arrays.fill(benefit, BigInteger.ZERO);

        for (String num : nums) {
            int len = num.length();
            for (int idx = 0; idx < len; idx++) {
                char c = num.charAt(idx);
                int v = (c <= '9') ? c - '0' : c - 'A' + 10;   // 현재 자릿값(0~35)
                int p = len - 1 - idx;             // 36^p의 p
                BigInteger diff = BigInteger.valueOf(35 - v).multiply(pow36[p]);
                benefit[v] = benefit[v].add(diff);
            }
        }

        //benefit이 큰 순서대로 정렬해 상위 K개 선택
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < 36; i++) order.add(i);
        order.sort((a, b) -> benefit[b].compareTo(benefit[a]));

        Set<Integer> picked = new HashSet<>();
        for (int i = 0; i < K && i < 36; i++) picked.add(order.get(i));

        BigInteger total = BigInteger.ZERO;
        for (String num : nums) {
            total = total.add(new BigInteger(num, 36));
        }
        for (int v : picked) {
            total = total.add(benefit[v]);
        }
        String result = total.toString(36).toUpperCase();
        if (result.isEmpty()) result = "0";
        System.out.println(result);
    }
}