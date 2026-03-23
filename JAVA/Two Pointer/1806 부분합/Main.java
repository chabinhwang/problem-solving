import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        int left = 0;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int right = 0; right < N; right++) {
            arr[right] = Integer.parseInt(st.nextToken());
            sum += arr[right];

            // 만일 left부터 right까지 합이 S보다 크다면, left 줄일 수 있을때까지 줄이면서 길이 최소화
            while (sum >= S) {
                min = Math.min(min, right - left + 1);
                sum -= arr[left];
                left += 1;
            }

        }
        System.out.println(min == Integer.MAX_VALUE ? 0 : min);
    }
}
